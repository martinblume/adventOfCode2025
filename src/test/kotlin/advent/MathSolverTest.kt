package advent

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MathSolverTest {

    val mathSolver = MathSolver()

    @Test
    fun testSolve() {
        assertEquals(4277556.toBigInteger(), mathSolver.solveProblem(fileToLines("/06/testInput.txt")))
        assertEquals(6371789547734.toBigInteger(), mathSolver.solveProblem(fileToLines("/06/input.txt")))
    }

    @Test
    fun testSolve2() {
        //assertEquals(3263827.toBigInteger(), mathSolver.solveProblem2(fileToLines("/06/testInput.txt")))
        assertEquals(6371789547734.toBigInteger(), mathSolver.solveProblem2(fileToLines("/06/testInput.txt")))
    }

    fun fileToLines(fileName: String): List<List<String>> {
        val lines = this.javaClass.getResourceAsStream(fileName)!!.bufferedReader().readLines()
            .map { it.split(" ") }.map { line -> line.map { it.removeDuplicateBlanks() }.filter { it != "" } }
        check(lines.all { it.size == lines[0].size })
        return lines
    }


}

private fun String.removeDuplicateBlanks(): String {
    return this.split(" ").joinToString(" ") { it.trim() }
}
