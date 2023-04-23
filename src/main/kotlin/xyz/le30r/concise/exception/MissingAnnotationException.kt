/*
 *  23.04.2023, 13:57
 *  Created by Ivan Marinin
 */

package xyz.le30r.concise.exception

class MissingAnnotationException(override val message: String?) : Exception(message) {
}