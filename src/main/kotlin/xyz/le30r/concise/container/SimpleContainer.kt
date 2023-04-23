/*
 *  22.04.2023, 23:54
 *  Created by Ivan Marinin
 */

package xyz.le30r.concise.container

class SimpleContainer : Container {
    private val beanRegistry = mutableMapOf<Class<*>, MutableList<Any?>>()

    override fun <T : Class<*>> getBean(clazz: T): List<Any?>? {
        return beanRegistry[clazz];
    }

    override fun getBean(name: String) {
        TODO("Not yet implemented")
    }

    override fun <T : Any> addBean(clazz: Class<*>, bean: T) {
        if (beanRegistry[clazz] == null) {
            beanRegistry[clazz] = mutableListOf()
        }
        beanRegistry[clazz]!!.add(bean)
    }
}