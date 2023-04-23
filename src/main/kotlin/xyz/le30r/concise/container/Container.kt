/*
 *  22.04.2023, 23:44
 *  Created by Ivan Marinin
 */

package xyz.le30r.concise.container

interface Container {
    fun <T> getBean(clazz: Class<T>): List<T>?
    fun getBean(name: String);
    fun getAllBeans(): Map<Class<*>, List<Any?>?>
    fun <T : Any> addBean(clazz: Class<*>, bean: T);
}