package advent

private const val TOILET_ROLL = '@'

private const val EMPTY = '.'

class ToiletRollCounter {

    fun countAccessibleToiletRolls(grid: List<String>): Int = grid.mapIndexed { index, string ->
        val tmp = string.mapIndexed { stringIndex, ch ->
            if (ch == TOILET_ROLL) {
                val neighbours = getNeighbors(grid, index, stringIndex, grid.size, string.length)
                neighbours.count { it == TOILET_ROLL }.toString()
            } else {
                ch
            }
        }
        tmp.filter { it != EMPTY }.map { "$it".toInt() }.count { it < 4 }
    }.sum()

    private fun getNeighbors(grid: List<String>, i: Int, j: Int, limitI: Int, limitJ: Int): String {
        val lowerBoundX = if (i - 1 >= 0) i - 1 else i
        val upperBoundX = if (i + 1 < limitI) i + 1 else i
        val lowerBoundY = if (j - 1 >= 0) j - 1 else j
        val upperBoundY = if (j + 1 < limitJ) j + 1 else j
        val stringBuilder = StringBuilder()
        for (x in lowerBoundX..upperBoundX) {
            for (y in lowerBoundY..upperBoundY) {
                if (x != i || y != j) {
                    stringBuilder.append(grid[x][y])
                }
            }
        }
        return stringBuilder.toString()
    }

    fun countAccessibleToiletRolls2(grid: List<String>): Int {
        val mutableGrid = grid.toMutableList()
        while (countAccessibleToiletRolls(mutableGrid) > 0) {
            removeAccessibleToiletRolls(mutableGrid)
        }
        return countToiletRolls(grid) - countToiletRolls(mutableGrid)
    }

    private fun countToiletRolls(grid: List<String>): Int = grid.sumOf { it.count { ch -> ch == TOILET_ROLL } }

    private fun removeAccessibleToiletRolls(grid: MutableList<String>) {
        grid.forEachIndexed { index, string ->
            val newString = string.mapIndexed { stringIndex, ch ->
                if (ch == TOILET_ROLL) {
                    val neighbours = getNeighbors(grid, index, stringIndex, grid.size, string.length)
                    val neighborCount = neighbours.count { it == TOILET_ROLL }
                    if (neighborCount < 4) EMPTY else TOILET_ROLL
                } else {
                    ch
                }
            }
            grid[index] = newString.joinToString(separator = "")
        }
    }
}