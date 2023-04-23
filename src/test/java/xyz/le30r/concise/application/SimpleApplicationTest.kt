/*
 *  23.04.2023, 13:45
 *  Created by Ivan Marinin
 */

package xyz.le30r.concise.application

import org.junit.jupiter.api.Test
import xyz.le30r.concise.annotation.ConciseApplication
import xyz.le30r.concise.units.SecondTestUnit
import xyz.le30r.concise.units.TestUnit
import kotlin.test.assertEquals

@ConciseApplication(["xyz.le30r"])
class SimpleApplicationTest : SimpleApplication() {
    @Test
    fun startApplication() {
        val container = run(SimpleApplicationTest::class.java)
        val testUnit = container.getBean(TestUnit::class.java)
        val secondUnit = container.getBean(SecondTestUnit::class.java)

        assertEquals(secondUnit?.get(0)?.getFirst(), testUnit?.get(0))
    }
}