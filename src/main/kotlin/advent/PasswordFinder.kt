package advent

class PasswordFinder {

    fun findPassword(): Int {
        val lines: List<String> = this.javaClass.getResourceAsStream("/01/input.txt")!!.bufferedReader().readLines()

        var current = 50
        var nrOfZeros = 0
        lines.forEach { line ->
            val direction = line.first()
            val number = line.substring(1).toInt()

            var increase = if (direction == 'L') current - number else current + number
            while (increase < 0 || increase > 99) {
                if (increase < 0) {
                    increase += 100
                } else {
                    increase -= 100
                }
            }
            current = increase
            if (current == 0) {
                nrOfZeros++
            }
        }

        return nrOfZeros
    }

    fun findPassword2(lines: List<String>): Int {

        var current = 50
        var nrOfZeros = 0
        lines.forEach { line ->
            val direction = line.first()
            val number = line.substring(1).toInt()

            var increase = if (direction == 'L') -number else number

            while (increase < -99 || increase > 99) {
                if (increase < 99) {
                    increase += 100
                } else {
                    increase -= 100
                }
                nrOfZeros++
            }
            val res = current + increase
            if(res<0) {
                current = res + 100;
                nrOfZeros++
            } else if (res>99) {
                current = res%100
                nrOfZeros++
            } else if (res == 0) {
                nrOfZeros++
            }
        }

        return nrOfZeros
    }

    fun modulo(foo: Int) = foo % 100
}