/*
 *  23.04.2023, 14:28
 *  Created by Ivan Marinin
 */

package xyz.le30r.concise.processor


interface BeanPostProcessor {
    fun postInit(clazz: Class<*>, obj: Any): Any
    fun postConstruct(clazz: Class<*>, obj: Any): Any
}
