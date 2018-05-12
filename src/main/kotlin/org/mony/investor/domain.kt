package org.mony.investor

import java.math.BigDecimal

data class Account(val name: String, val positions: List<Position>)

data class Position(
    val name: String,
    val isin: String = "",
    val type: String,
    val shares: BigDecimal,
    val price: BigDecimal,
    val buy: Boolean = true
) {
    val amount = price * shares
}

data class Allocation(val type: String, val target: BigDecimal)

data class Input(val accounts: List<Account>, val allocations: List<Allocation>, val investment: BigDecimal) {
    val positions = accounts.flatMap { it.positions }
}
