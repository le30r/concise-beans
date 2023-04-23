/*
 *  23.04.2023, 14:36
 *  Created by Ivan Marinin
 */

package xyz.le30r.concise.processor

const val DEFAULT_BPP_ORDER = 0
abstract class OrderedBeanPostProcessor(
    val order: Int = DEFAULT_BPP_ORDER
)  : BeanPostProcessor {

}