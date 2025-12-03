package advent

import java.math.BigInteger

class InvalidIdFinder {

    fun findInvalidIds(intervals: List<String>): BigInteger {
        return intervals.flatMap { interval ->
            val split = interval.split('-')
            val invalidIds = mutableListOf<String>()
            val base = split[0].toBigInteger()
            val limit = split[1].toBigInteger().minus(base).toInt()
            for (number in 0..limit) {
                val numberAsString = base.plus(number.toBigInteger()).toString()
                val half = numberAsString.length / 2
                val half1 = numberAsString.take(half)
                val half2 = numberAsString.substring(half)
                if(half1 == half2) {
                    invalidIds.add(numberAsString)
                }
            }
            invalidIds
        }.sumOf { it.toBigInteger() }
    }
}