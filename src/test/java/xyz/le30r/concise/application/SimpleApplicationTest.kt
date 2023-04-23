/*
 *  23.04.2023, 13:45
 *  Created by Ivan Marinin
 */

package xyz.le30r.concise.application

import org.junit.jupiter.api.Test
import xyz.le30r.concise.annotation.ConciseApplication

@ConciseApplication(["xyz.le30r"])
class SimpleApplicationTest : SimpleApplication() {
    @Test
    fun startApplication() {
        run(SimpleApplicationTest::class.java)
    }
}