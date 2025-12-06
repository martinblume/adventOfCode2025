package `advent`

import kotlin.test.assertEquals

class PasswordFinderTest {

    val passwordFinder = PasswordFinder()

    @org.junit.jupiter.api.Test
    fun testFindPassword() {
        assertEquals(984, passwordFinder.findPassword())
    }

    @org.junit.jupiter.api.Test
    fun testFindPassword2() {
        assertEquals(1, passwordFinder.findPassword2(listOf("L50")))
        assertEquals(1, passwordFinder.findPassword2(listOf("R50")))
        assertEquals(0, passwordFinder.findPassword2(listOf("L49")))
        assertEquals(0, passwordFinder.findPassword2(listOf("R49")))
        assertEquals(3, passwordFinder.findPassword2(listOf("L60", "R20", "L10")))
        assertEquals(10, passwordFinder.findPassword2(listOf("L1000")))
        assertEquals(10, passwordFinder.findPassword2(listOf("R1000")))
        assertEquals(11, passwordFinder.findPassword2(listOf("R1050")))
        assertEquals(2, passwordFinder.findPassword2(listOf("L50", "L100")))
        assertEquals(5, passwordFinder.findPassword2(listOf("L50", "L400")))
        assertEquals(1, passwordFinder.findPassword2(listOf("L49", "R99")))
        assertEquals(2, passwordFinder.findPassword2(listOf("L51", "L100")))
        assertEquals(2, passwordFinder.findPassword2(listOf("L51", "R100")))
        assertEquals(3, passwordFinder.findPassword2(listOf("L51", "R101")))
        assertEquals(21, passwordFinder.findPassword2(listOf("R1050", "R1000")))
        assertEquals(8, passwordFinder.findPassword2(listOf("L50", "R300", "L200", "R1", "L101")))
        assertEquals(
            6,
            passwordFinder.findPassword2(
                this.javaClass.getResourceAsStream("/01/testInput.txt")!!.bufferedReader().readLines()
            )
        )
        val lines = this.javaClass.getResourceAsStream("/01/input.txt")!!.bufferedReader().readLines()
        assertEquals(5616, passwordFinder.findPassword2(lines))
    }

    @org.junit.jupiter.api.Test
    fun testModulo() {
        assertEquals(99, passwordFinder.modulo(99))
        assertEquals(0, passwordFinder.modulo(0))
        assertEquals(12, passwordFinder.modulo(12))
    }
}