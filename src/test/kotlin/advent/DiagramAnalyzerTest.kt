package advent

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DiagramAnalyzerTest {

    val diagramAnalyzer = DiagramAnalyzer()

    @Test
    fun testCountBeamSplits() {
            assertEquals(21, diagramAnalyzer.countBeamSplits(fileToIntervals("/07/testInput.txt")))
            assertEquals(1524, diagramAnalyzer.countBeamSplits(fileToIntervals("/07/input.txt")))
    }

    fun fileToIntervals(fileName: String): List<String> {
        val lines = this.javaClass.getResourceAsStream(fileName)!!.bufferedReader().readLines()
       return lines
    }

}