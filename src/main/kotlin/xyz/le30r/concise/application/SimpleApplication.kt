/*
 *  23.04.2023, 13:47
 *  Created by Ivan Marinin
 */

package xyz.le30r.concise.application

import xyz.le30r.concise.annotation.ConciseApplication
import xyz.le30r.concise.container.Container
import xyz.le30r.concise.container.SimpleContainer
import xyz.le30r.concise.exception.MissingAnnotationException
import xyz.le30r.concise.loader.Loader
import xyz.le30r.concise.loader.SimpleContainerLoader

abstract class SimpleApplication : Application {
    private val loader: Loader<SimpleContainer> = SimpleContainerLoader()
    override fun run(clazz: Class<*>): Container {
        if (clazz.isAnnotationPresent(ConciseApplication::class.java)) {
            return loader.load(clazz.getAnnotation(ConciseApplication::class.java).packageNames)
        } else {
            throw MissingAnnotationException("The application class must have the ConciseApplication annotation")
        }
    }
}