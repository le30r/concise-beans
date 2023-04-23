/*
 *  23.04.2023, 00:59
 *  Created by Ivan Marinin
 */

package xyz.le30r.concise.annotation

@Retention(AnnotationRetention.RUNTIME)
annotation class ConciseApplication(val packageNames: Array<String>)
