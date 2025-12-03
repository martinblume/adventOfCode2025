package advent

import org.junit.jupiter.api.Assertions.*
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
}