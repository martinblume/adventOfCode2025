package advent

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ToiletRollCounterTest {

    val testInput = listOf(
        "..@@.@@@@.",
        "@@@.@.@.@@",
        "@@@@@.@.@@",
        "@.@@@@..@.",
        "@@.@@@@.@@",
        ".@@@@@@@.@",
        ".@.@.@.@@@",
        "@.@@@.@@@@",
        ".@@@@@@@@.",
        "@.@.@@@.@."
    )
    val toiletRollCounter = ToiletRollCounter()

    @Test
    fun testCountToiletRolls() {
        assertEquals(13, toiletRollCounter.countAccessibleToiletRolls(testInput))
        assertEquals(1578, toiletRollCounter.countAccessibleToiletRolls(fileToList("/04/input.txt")))
    }

    @Test
    fun testCountToiletRolls2() {
        assertEquals(43, toiletRollCounter.countAccessibleToiletRolls2(testInput))
        assertEquals(10132, toiletRollCounter.countAccessibleToiletRolls2(fileToList("/04/input.txt")))
    }

    fun fileToList(fileName: String): List<String> {
        val lines = this.javaClass.getResourceAsStream(fileName)!!.bufferedReader().readLines()
        return lines
    }
}