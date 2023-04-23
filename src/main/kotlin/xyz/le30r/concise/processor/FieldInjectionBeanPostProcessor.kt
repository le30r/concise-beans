/*
 *  23.04.2023, 14:32
 *  Created by Ivan Marinin
 */

package xyz.le30r.concise.processor

import xyz.le30r.concise.container.Container
import xyz.le30r.concise.exception.AmbiguousBeanInjectionException
import xyz.le30r.concise.exception.MissingBeanException
import javax.inject.Inject

const val FIELD_INJECTION_BPP_ORDER = -30

class FieldInjectionBeanPostProcessor(private val container: Container) : OrderedBeanPostProcessor(FIELD_INJECTION_BPP_ORDER) {
    override fun postInit(clazz: Class<*>, obj: Any): Any {
        val fields = obj.javaClass.declaredFields
        for (field in fields) {
            if (field.isAnnotationPresent(Inject::class.java)) {
                field.isAccessible = true
                val fieldClass = field.type
                val bean = container.getBean(fieldClass)
                    ?: throw MissingBeanException("Object not found for matching container")
                if (!fieldClass.isArray && bean.count() > 1) {
                    throw AmbiguousBeanInjectionException("Found multiple beans for the $fieldClass class of $field")
                }
                if (fieldClass.isArray) {
                    field.set(obj, bean.toTypedArray())
                } else {
                    field.set(obj, bean[0])
                }
            }
        }
        return obj
    }

    override fun postConstruct(clazz: Class<*>, obj: Any): Any {
        TODO("Not yet implemented")
    }

}