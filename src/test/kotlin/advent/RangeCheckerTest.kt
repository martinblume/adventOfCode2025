package advent

import org.junit.jupiter.api.Test
import java.math.BigInteger
import kotlin.test.assertEquals

class RangeCheckerTest {

    val rangeChecker = RangeChecker()

    @Test
    fun testInRange() {
        assertEquals(3, rangeChecker.countNumbersInRange(fileToRanges("/05/testInput.txt")))
        assertEquals(3, rangeChecker.countNumbersInRange(fileToRanges("/05/input.txt")))
    }

    private fun fileToRanges(fileName: String): Pair<List<BigInteger>, List<Pair<BigInteger, BigInteger>>> {
        val lines = this.javaClass.getResourceAsStream(fileName)!!.bufferedReader().readLines()
        val ranges = mutableListOf<Pair<BigInteger, BigInteger>>()
        var emptyLineIndex = -1
        for (i in 0..lines.size) {
            val line = lines[i]
            if (line != "") {
                val numbers = line.split("-")
                val left = numbers[0].toBigInteger()
                val right = numbers[1].toBigInteger()
                ranges.add(Pair(left, right))
            } else {
                emptyLineIndex = i
                break
            }
        }
        val numbers = mutableListOf<BigInteger>()
        for (i in emptyLineIndex + 1..<lines.size) {
            numbers.add(lines[i].toBigInteger())
        }
        return Pair(numbers, ranges)
    }
}