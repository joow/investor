package org.mony.investor

import java.math.BigDecimal
import java.math.RoundingMode

class Portfolio(private val positions: List<Position>) {

    private val amount: BigDecimal = positions.map { it.amount }.fold(BigDecimal.ZERO) { acc, amount -> acc + amount }

    private fun allocations() =
        positions.groupingBy { it.type }.fold(BigDecimal.ZERO) { acc, position -> acc + position.amount }

    private fun candidate(type: String, max: BigDecimal) =
            positions
                .filter { it.type == type && it.buy && it.price <= max }
                .sortedByDescending { it.price }
                .firstOrNull()

    tailrec fun optimize(investment: BigDecimal, allocations: List<Allocation>, acc: List<Position> = emptyList()): Map<String, Int> {
        val newPortfolio = Portfolio(positions.plus(acc))
        val futureAmount = newPortfolio.amount + investment
        val currentAllocations = newPortfolio.allocations()
        val idealAllocations = allocations.map {
            Pair(
                it.type,
                it.target.divide(BigDecimal("100"), 2, RoundingMode.HALF_EVEN) * futureAmount
            )
        }

        val differences = idealAllocations
            .map { (type, amount) -> Pair(type, currentAllocations.getOrDefault(type, BigDecimal.ZERO) - amount) }
            .filter { it.second < BigDecimal.ZERO }
            .sortedBy { it.second }

        val nextPosition = differences.mapNotNull { candidate(it.first, investment) }
            .firstOrNull()?.copy(shares = 1)

        return if (nextPosition == null) acc.groupingBy { it.type }.eachCount()
        else optimize(investment - nextPosition.price, allocations, acc.plus(nextPosition))
    }
}
