package advent

import java.math.BigInteger

class RangeChecker {

    fun countNumbersInRange(pair: Pair<List<BigInteger>, List<Pair<BigInteger, BigInteger>>>) =
        countNumbersInRange(pair.first, pair.second)

    fun countNumbersInRange(numbers: List<BigInteger>, ranges: List<Pair<BigInteger, BigInteger>>): Int {
        return numbers.count { isInRange(it, ranges) }
    }

    fun isInRange(number: BigInteger, ranges: List<Pair<BigInteger, BigInteger>>): Boolean {
        return ranges.any { number >= it.first && number <= it.second }
    }

    fun countNumbersInRange2(ranges: List<Pair<BigInteger, BigInteger>>): BigInteger {
        val visitedRanges = HashSet<Pair<BigInteger, BigInteger>>()
        var result = BigInteger.ZERO
        ranges.forEach { range ->
            val overLappingRanges = findOverLappingRanges(range, visitedRanges)
            val overLappingNumbers = countNumbers(overLappingRanges)
            val newRange = findNewRange(overLappingRanges + range)
            visitedRanges.removeAll(overLappingRanges)
            visitedRanges.add(newRange)
            result-=overLappingNumbers
            result += (newRange.second+ BigInteger.ONE -newRange.first)
        }
        return result
    }

    private fun findNewRange(overLappingRanges: Set<Pair<BigInteger, BigInteger>>): Pair<BigInteger, BigInteger> {
        var low: BigInteger? = null
        var high = BigInteger.ZERO
        overLappingRanges.forEach { (visitedLow, visitedHigh) ->
            if (low == null || visitedLow < low) {
                low = visitedLow
            }
            if (visitedHigh > high) {
                high = visitedHigh
            }
        }
        return Pair(low!!, high)
    }

    private fun countNumbers(ranges: Set<Pair<BigInteger, BigInteger>>): BigInteger {
        var result = BigInteger.ZERO
        ranges.forEach { (low, high) ->
            result += high.plus(BigInteger.ONE).minus(low)
        }
        return result
    }

    private fun findOverLappingRanges(
        range: Pair<BigInteger, BigInteger>,
        visitedRanges: Set<Pair<BigInteger, BigInteger>>
    ): Set<Pair<BigInteger, BigInteger>> {
        if (visitedRanges.isEmpty()) {
            return emptySet()
        }
        return visitedRanges.filter {
            (it.first >= range.first && it.second <= range.second) ||
                    (it.first <= range.first && it.second <= range.second && it.second>=range.first) ||
                    (it.first >= range.first && it.second >= range.second && it.first<=range.second) ||
                    (it.first <= range.first && it.second >= range.second)
        }.toSet()
    }


    private fun findHighest(ranges: List<Pair<BigInteger, BigInteger>>): Pair<BigInteger, BigInteger> {
        var max = BigInteger.ZERO
        var low: BigInteger? = null
        ranges.forEach {
            if (low == null || it.first < low) {
                low = it.first
            }
            if (it.second > max) {
                max = it.second
            }
        }
        return Pair(low!!, max)
    }
}