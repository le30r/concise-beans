/*
 *  22.04.2023, 23:54
 *  Created by Ivan Marinin
 */

package xyz.le30r.concise.container

import java.util.Collections

class SimpleContainer : Container {
    private val beanRegistry = mutableMapOf<Class<*>, MutableList<Any?>>()

    @Suppress("UNCHECKED_CAST")
    override fun <T> getBean(clazz: Class<T>): List<T> {
        val result = mutableListOf<T>()
        val beans = beanRegistry[clazz] ?: mutableListOf()
        return beans.map { clazz.cast(it) }
    }

    override fun getBean(name: String) {
        TODO("Not yet implemented")
    }

    override fun getAllBeans(): Map<Class<*>, List<Any?>?> {
        return beanRegistry.toMap()
    }

    override fun <T : Any> addBean(clazz: Class<*>, bean: T) {
        if (beanRegistry[clazz] == null) {
            beanRegistry[clazz] = mutableListOf()
        }
        beanRegistry[clazz]!!.add(bean)
    }
}