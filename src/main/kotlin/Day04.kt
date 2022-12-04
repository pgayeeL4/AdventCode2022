import java.io.File

fun main() {

    fun part01(): Int {
        val inputStream = File("./src/main/resources/Day04Input.txt").inputStream()
        var numOfRanges = 0

        inputStream.bufferedReader().forEachLine { sectionAssignmentPair ->
            val rangePair = sectionAssignmentPair.getElfRanges()
            if(rangePair.first.contains(rangePair.second) || rangePair.second.contains(rangePair.first)) {
                numOfRanges++
            }
        }

        return numOfRanges
    }

    fun part02(): Int {
        val inputStream = File("./src/main/resources/Day04Input.txt").inputStream()
        var numOfRanges = 0

        inputStream.bufferedReader().forEachLine { sectionAssignmentPair ->
            val rangePair = sectionAssignmentPair.getElfRanges()
            val intersect = rangePair.first.intersect(rangePair.second)
            if(intersect.isNotEmpty()) {
                numOfRanges++
            }
        }

        return numOfRanges
    }

    println(part01())
    println(part02())

}