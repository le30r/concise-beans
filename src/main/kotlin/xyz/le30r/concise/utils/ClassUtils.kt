/*
 *  23.04.2023, 00:54
 *  Created by Ivan Marinin
 */

package xyz.le30r.concise.utils

import java.io.File
import java.io.IOException
import java.net.URL
import java.util.*



@Throws(ClassNotFoundException::class, IOException::class)
fun findAllClassesUsingClassLoader(packageName: String): Set<Class<*>> {
    val classLoader = Thread.currentThread().contextClassLoader!!
    val path = packageName.replace('.', '/')
    val resources: Enumeration<URL> = classLoader.getResources(path)
    val dirs: MutableList<File> = ArrayList()
    while (resources.hasMoreElements()) {
        val resource: URL = resources.nextElement()
        dirs.add(File(resource.file))
    }
    val classes = ArrayList<Class<*>>()
    for (directory in dirs) {
        classes.addAll(findClasses(directory, packageName)!!)
    }
    return classes.toSet<Class<*>>()
}

@Throws(ClassNotFoundException::class)
private fun findClasses(directory: File, packageName: String): List<Class<*>> {
    val classes: MutableList<Class<*>> = ArrayList()
    if (!directory.exists()) {
        return classes
    }
    val files = directory.listFiles()
    for (file in files) {
        if (file.isDirectory) {
            assert(!file.name.contains("."))
            classes.addAll(findClasses(file, packageName + "." + file.name)!!)
        } else if (file.name.endsWith(".class")) {
            classes.add(Class.forName(packageName + '.' + file.name.substring(0, file.name.length - 6)))
        }
    }
    return classes
}