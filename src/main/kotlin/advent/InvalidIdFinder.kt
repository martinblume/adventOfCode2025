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
                if (half1 == half2) {
                    invalidIds.add(numberAsString)
                }
            }
            invalidIds
        }.sumOf { it.toBigInteger() }
    }

    fun findInvalidIds2(intervals: List<String>): BigInteger {
        return intervals.flatMap { interval ->
            val split = interval.split('-')
            val invalidIds = mutableListOf<String>()
            val base = split[0].toBigInteger()
            val limit = split[1].toBigInteger().minus(base).toInt()
            for (number in 0..limit) {
                val numberAsString = base.plus(number.toBigInteger()).toString()
                for (sequenceLength in 1..Math.max(1, numberAsString.length / 2)) {
                    val sequences = mutableListOf<String>()
                    var index = 0
                    while (index <= numberAsString.length - sequenceLength) {
                        sequences.add(numberAsString.substring(index, index + sequenceLength))
                        index += sequenceLength
                    }
                    if (sequences.size * sequenceLength == numberAsString.length &&
                        sequences.size > 1 &&
                        sequences.all { it == sequences[0] }
                    ) {
                        invalidIds.add(numberAsString)
                    }
                }
            }
            invalidIds.distinct()
        }.sumOf { it.toBigInteger() }
    }
}