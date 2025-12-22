package advent

import java.math.BigInteger

class MathSolver {

    fun solveProblem(lines: List<List<String>>): BigInteger {
        val problems = MutableList<MathProblem>(
            lines[0].size
        ) { MathProblem(mutableListOf(), Operator.PLUS) }
        val nrOfProblems = problems.size
        val nrOfNumbers = lines.size - 1
        for (i in 0..<nrOfNumbers) {
            for (j in 0..<nrOfProblems) {
                problems[j].numbers.add(lines[i][j].toBigInteger())
            }
        }
        problems.forEachIndexed { index, problem ->
            val operator = lines[lines.size - 1][index]
            problem.operator = if (operator == "+") Operator.PLUS else Operator.TIMES
        }

        return problems.map { problem ->
            problem.numbers.reduce { acc, number ->
                if (problem.operator == Operator.TIMES) number.times(acc) else number.plus(acc)
            }
        }.reduce { acc, number -> acc.plus(number) }
    }

    fun solveProblem2(lines: List<List<String>>): BigInteger {
        val problems = MutableList<MathProblem2>(
            lines[0].size
        ) { MathProblem2(mutableListOf(), Operator.PLUS) }
        val nrOfProblems = problems.size
        val nrOfNumbers = lines.size - 1

        for (i in 0..<nrOfNumbers) {
            for (j in 0..<nrOfProblems) {
                problems[j].numbers.add(lines[i][j])
            }
        }
        problems.forEachIndexed { index, problem ->
            val operator = lines[lines.size - 1][index]
            problem.operator = if (operator == "+") Operator.PLUS else Operator.TIMES
        }

        problems.forEachIndexed { index, problem ->
            problem.numbers.forEach {
                if (it.length > problem.hightesNumberLength) {
                    problem.hightesNumberLength = it.length
                }
            }
        }

        problems.forEachIndexed { ind, problem ->
            problem.constructedNumbers = MutableList<Int>(problem.hightesNumberLength) { 0 }
            for (k in 0..problem.hightesNumberLength - 1) {
                problem.numbers.forEachIndexed { index, stringNumber ->
                    val digit = stringNumber.last()
                    problem.numbers.set(index, stringNumber.take(stringNumber.length - 1))
                    val constructed = problem.constructedNumbers[k].plus(
                        digit.toString().toInt() * Math.pow(
                            10.toDouble(),
                            problem.hightesNumberLength - 1 - l.toDouble()
                        )
                    )
                    problem.constructedNumbers.set(
                        k, constructed.toInt()
                    )
                }
            }
        }

        return BigInteger.ZERO
    }


    class MathProblem(val numbers: MutableList<BigInteger>, var operator: Operator)

    class MathProblem2(
        val numbers: MutableList<String>,
        var operator: Operator,
        var hightesNumberLength: Int = 0,
        var constructedNumbers: MutableList<Int> = mutableListOf<Int>(),
    )

    enum class Operator {
        PLUS, TIMES
    }

}