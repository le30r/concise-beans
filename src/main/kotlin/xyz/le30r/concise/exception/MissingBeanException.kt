/*
 *  23.04.2023, 14:55
 *  Created by Ivan Marinin
 */

package xyz.le30r.concise.exception

class MissingBeanException(override val message: String?) : Exception(message) {
}