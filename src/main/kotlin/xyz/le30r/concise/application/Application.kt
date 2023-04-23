/*
 *  23.04.2023, 13:46
 *  Created by Ivan Marinin
 */
package xyz.le30r.concise.application

import xyz.le30r.concise.container.Container

interface Application {
    fun run(clazz: Class<*>): Container
}