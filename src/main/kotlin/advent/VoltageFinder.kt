package advent

import java.math.BigInteger

class VoltageFinder {

    fun findMaxVoltage(banks: List<String>): Int {
        return banks.fold(0) { sum, batteries ->
            var max = 0
            for (i in 0 until batteries.length) {
                for (j in i + 1 until batteries.length) {
                    val voltage = "${batteries[i]}${batteries[j]}".toInt()
                    if (voltage > max) {
                        max = voltage
                    }
                }
            }
            max + sum
        }
    }

    fun findMaxVoltage2(banks: List<String>): BigInteger {
        return banks.fold(BigInteger.ZERO) { sum, bank ->
            val max = findMaxVoltageInBank(bank = bank, remainingNrOfBatteries = 12)
            max.toBigInteger() + sum
        }
    }

    private fun findMaxVoltageInBank(bank: String, remainingNrOfBatteries: Int, maxDigit: Int = 9): String {
        if(bank.isEmpty() ||remainingNrOfBatteries==0) {
            return ""
        }
        val range = (1..maxDigit).reversed()
        for (i in range) {
            val index = bank.indexOf("$i")
            if(index>-1) {
                val newBank = bank.substring(index+1)
                if(newBank.length>=remainingNrOfBatteries-1) {
                    val result = "${bank[index]}${findMaxVoltageInBank(newBank, remainingNrOfBatteries-1)}".toSaveBigInteger()
                    if(result> BigInteger.ZERO) {
                        return result.toString()
                    }
                }
            }
        }
        return ""
    }

    private fun String.toSaveBigInteger(): BigInteger {
        if (this.isEmpty()) {
            return BigInteger.ZERO
        }
        return this.toBigInteger()
    }
}