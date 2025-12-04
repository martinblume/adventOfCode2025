package advent

import org.junit.jupiter.api.Test
import java.math.BigInteger
import kotlin.test.assertEquals

class VoltageFinderTest {

    val voltageFinder = VoltageFinder()

    @Test
    fun testPart1() {
        assertEquals(98, voltageFinder.findMaxVoltage(listOf("987654321111111")))
        assertEquals(89, voltageFinder.findMaxVoltage(listOf("811111111111119")))
        assertEquals(78, voltageFinder.findMaxVoltage(listOf("234234234234278")))
        assertEquals(92, voltageFinder.findMaxVoltage(listOf("818181911112111")))
        assertEquals(17107, voltageFinder.findMaxVoltage(fileToBanks("/03/input.txt")))
    }

    @Test
    fun testPart2() {
        //assertEquals(BigInteger.valueOf(987654321111), voltageFinder.findMaxVoltage2(listOf("987654321111111")))
        assertEquals(BigInteger.valueOf(169349762274117), voltageFinder.findMaxVoltage2(fileToBanks("/03/input.txt")))
    }

    fun fileToBanks(fileName: String): List<String> {
        val lines = this.javaClass.getResourceAsStream(fileName)!!.bufferedReader().readLines()
        return lines
    }
}