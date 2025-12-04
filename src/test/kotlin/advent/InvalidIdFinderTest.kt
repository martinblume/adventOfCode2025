package advent

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.math.BigInteger

class InvalidIdFinderTest {

    val invalidIdFinder = InvalidIdFinder()

    @Test
    fun testFindInvalidIds() {
        assertEquals(BigInteger.valueOf(33), invalidIdFinder.findInvalidIds(listOf("11-22")))
        val lines = this.javaClass.getResourceAsStream("/02/input.txt")!!.bufferedReader().readLines()
        val intervals = lines.first().split(",")
        assertEquals(BigInteger.valueOf(28846518423), invalidIdFinder.findInvalidIds(intervals))
    }

    @Test
    fun testFindInvalidId2() {
        assertEquals(BigInteger.valueOf(33), invalidIdFinder.findInvalidIds2(listOf("11-22")))
        assertEquals(BigInteger.valueOf(210), invalidIdFinder.findInvalidIds2(listOf("95-115")))
        assertEquals(BigInteger.valueOf(2009), invalidIdFinder.findInvalidIds2(listOf("998-1012")))
        assertEquals(BigInteger.valueOf(565656), invalidIdFinder.findInvalidIds2(listOf("565653-565659")))
        assertEquals(BigInteger.valueOf(824824824), invalidIdFinder.findInvalidIds2(listOf("824824821-824824827")))
        assertEquals(BigInteger.valueOf(2121212121), invalidIdFinder.findInvalidIds2(listOf("2121212118-2121212124")))
        assertEquals(
            BigInteger.valueOf(4174379265),
            invalidIdFinder.findInvalidIds2(fileToIntervals("/02/testInput.txt"))
        )
        assertEquals(BigInteger.valueOf(31578210022), invalidIdFinder.findInvalidIds2(fileToIntervals("/02/input.txt")))
    }

    fun fileToIntervals(fileName: String): List<String> {
        val lines = this.javaClass.getResourceAsStream(fileName)!!.bufferedReader().readLines()
        val intervals = lines.first().split(",")
        return intervals
    }
}