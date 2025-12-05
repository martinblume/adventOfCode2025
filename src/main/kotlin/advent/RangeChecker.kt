package advent

import java.math.BigInteger

class RangeChecker {

    fun countNumbersInRange(pair: Pair<List<BigInteger>, List<Pair<BigInteger, BigInteger>>>) = countNumbersInRange(pair.first, pair.second)

    fun countNumbersInRange(numbers: List<BigInteger>, ranges: List<Pair<BigInteger, BigInteger>>) : Int{
        return numbers.count { isInRange(it, ranges)}
    }

    fun isInRange(number: BigInteger, ranges: List<Pair<BigInteger, BigInteger>>): Boolean{
        return ranges.any{ number >= it.first && number <= it.second }
    }
}