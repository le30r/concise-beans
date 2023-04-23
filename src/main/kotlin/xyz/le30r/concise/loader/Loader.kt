/*
 *  23.04.2023, 00:23
 *  Created by Ivan Marinin
 */

package xyz.le30r.concise.loader

import xyz.le30r.concise.container.Container

interface Loader<T: Container> {
    fun load(packages: Array<String>): T
}