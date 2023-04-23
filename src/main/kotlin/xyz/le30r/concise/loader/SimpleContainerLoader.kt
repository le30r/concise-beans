/*
 *  23.04.2023, 00:24
 *  Created by Ivan Marinin
 */

package xyz.le30r.concise.loader

import xyz.le30r.concise.utils.findAllClassesUsingClassLoader
import xyz.le30r.concise.annotation.Unit
import xyz.le30r.concise.container.SimpleContainer
import xyz.le30r.concise.processor.FieldInjectionBeanPostProcessor

class SimpleContainerLoader : Loader<SimpleContainer> {
    private val container = SimpleContainer()
    override fun load(packages: Array<String>): SimpleContainer {
        if (packages.isEmpty()) {
            throw IllegalStateException("Packages are not represented in the annotation parameter")
        }
        for (`package` in packages) {
            collectBeans(`package`)
        }
        val fieldInjectionBeanPostProcessor =  FieldInjectionBeanPostProcessor(container)
        for (beans in container.getAllBeans()) {
            for (bean in beans.value!!) {
                fieldInjectionBeanPostProcessor.postInit(beans.key, bean ?: continue)
            }
        }

        return container
    }

    private fun collectBeans(packageName: String) {
        val classes = findAllClassesUsingClassLoader(packageName)
        for (clazz in classes) {
            if (clazz.isAnnotationPresent(Unit::class.java)) {
                val bean = createBeanFromClass(clazz)
                container.addBean(clazz, bean)
                for (`interface` in clazz.interfaces) {
                    container.addBean(`interface`, bean)
                }
            }
        }
    }

    private fun <T> createBeanFromClass(clazz: Class<T>) : T {
        val constructor = clazz.getConstructor()
        return constructor.newInstance()
    }

}
