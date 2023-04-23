/*
 *  22.04.2023, 23:44
 *  Created by Ivan Marinin
 */

package xyz.le30r.concise.container

interface Container {
    fun <T : Class<*>> getBean(clazz: T): List<Any?>?;
    fun getBean(name: String);
    fun <T : Any> addBean(clazz: Class<*>, bean: T);
}