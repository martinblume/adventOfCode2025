package advent

class DiagramAnalyzer {

    fun countBeamSplits(diagram: List<String>): Int {
        var beamIndices = listOf(findStartPosition(diagram.first()))
        var index = 1
        var numberOfSplits = 0
        while(index < diagram.size) {
            val line = diagram.get(index)
            val (newIndices, splits) = findNextBeamIndices(line = line, currentBeamIndices = beamIndices)
            beamIndices = newIndices.distinct()
            numberOfSplits += splits
            index ++
        }
        return numberOfSplits
    }

    fun findStartPosition(line: String): Int =
        line.indexOf('S').let { if (it == -1) throw IllegalStateException("S not found in line") else it }

    fun findNextBeamIndices(line: String, currentBeamIndices: List<Int>): Pair<List<Int>, Int> {
        return Pair(currentBeamIndices.flatMap { beamIndex ->
            if (line.get(beamIndex) == '.') listOf(beamIndex) else listOf(
                beamIndex - 1,
                beamIndex + 1
            )
        }, currentBeamIndices.count { line.get(it)== '^' && currentBeamIndices.contains(it)})
    }
}