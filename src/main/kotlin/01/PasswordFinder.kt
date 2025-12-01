package `01`

import java.io.File

class PasswordFinder {

    fun findPassword() : Int{
        val lines: List<String> = this.javaClass.getResourceAsStream("/01/input.txt")!!.bufferedReader().readLines()

        var current = 50
        var nrOfZeros = 0
        lines.forEach { line ->
            val direction = line.first()
            val number = line.substring(1).toInt()

            current = (if(direction=='L') current-number else current + number) % 100
            if(current==0) {
                nrOfZeros++
            }
        }

        return nrOfZeros
    }

    fun findPassword2() : Int{
        val lines: List<String> = this.javaClass.getResourceAsStream("/01/input.txt")!!.bufferedReader().readLines()

        var current = 50
        var nrOfZeros = 0
        lines.forEach { line ->
            val direction = line.first()
            val number = line.substring(1).toInt()

            var increase = if (direction == 'L') current - number else current + number
            while(increase<0 || increase >99) {
                if(increase<0) {
                    increase +=100
                } else {
                    increase -=100
                }
                nrOfZeros++
            }
            current = increase
            if(current==0) {
                nrOfZeros++
            }
        }

        return nrOfZeros
    }

    fun modulo (foo: Int) = foo % 100
}