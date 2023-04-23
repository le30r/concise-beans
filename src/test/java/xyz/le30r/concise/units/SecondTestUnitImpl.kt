/*
 *  23.04.2023, 15:37
 *  Created by Ivan Marinin
 */

package xyz.le30r.concise.units

import xyz.le30r.concise.annotation.Unit
import javax.inject.Inject
@Unit
class SecondTestUnitImpl : SecondTestUnit {
    @Inject
    lateinit var testUnit: TestUnit

    override fun getFirst(): TestUnit {
        return testUnit
    }
}