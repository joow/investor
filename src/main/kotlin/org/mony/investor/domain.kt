package org.mony.investor

import java.math.BigDecimal

data class Position(
    val name: String,
    val isin: String = "",
    val type: String,
    val shares: Int,
    val price: BigDecimal,
    val buy: Boolean = true
) {
    val amount = price * shares.toBigDecimal()
}

data class Allocation(val type: String, val target: BigDecimal)

data class Input(val positions: List<Position>, val allocations: List<Allocation>, val investment: BigDecimal)
