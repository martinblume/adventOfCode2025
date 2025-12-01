package `01`

class PasswordFinderTest {

    val passwordFinder = PasswordFinder()

    @org.junit.jupiter.api.Test
    fun testFindPassword() {
        org.junit.jupiter.api.Assertions.assertEquals(984, passwordFinder.findPassword())
    }

    @org.junit.jupiter.api.Test
    fun testFindPassword2() {
        org.junit.jupiter.api.Assertions.assertEquals(3170, passwordFinder.findPassword2())
    }

    @org.junit.jupiter.api.Test
    fun testModulo() {
        org.junit.jupiter.api.Assertions.assertEquals(99, passwordFinder.modulo(99))
        org.junit.jupiter.api.Assertions.assertEquals(0, passwordFinder.modulo(0))
        org.junit.jupiter.api.Assertions.assertEquals(12, passwordFinder.modulo(12))
    }
}