package org.mony.investor

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.math.BigDecimal

val INPUT: Input =
    OBJECT_MAPPER.readValue(InputTest::class.java.classLoader.getResource("input.json"), Input::class.java)

class InputTest {
    @Test
    fun `should deserialize JSON`() {
        assertThat(INPUT.accounts).hasSize(3)
        assertThat(INPUT.positions).hasSize(5)
        assertThat(INPUT.allocations).hasSize(5)
        assertThat(INPUT.investment).isEqualTo(BigDecimal("1000"))
    }
}
