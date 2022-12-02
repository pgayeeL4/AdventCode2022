import java.io.File
import kotlin.math.max

fun main() {

    /*
    Input: File with list of numbers, numbers separated into groups
        Groups of numbers are separated by double newlines
        Each number in a group is separated by a newline

    Output: Largest sum of a group of numbers

    Design in abstract:
        Track running sum, and max sum, both initialized to 0
        Read file line by line

        if end of block, then compare running sum to max sum
            if running sum > max sum, then max sum = running sum
            set running sum back to 0
        if number, then add to running sum
     */
    fun part01(): Int {
        val inputStream = File("./src/main/resources/Day01Input.txt").inputStream()
        var runningSum = 0
        var maxSum = 0

        inputStream.bufferedReader().forEachLine {
            if(it == "/n" || it.isEmpty()) {
                maxSum = max(maxSum, runningSum)
                runningSum = 0
            } else {
                runningSum += it.toInt()
            }
        }

        return maxSum
    }

    /*
    Input: File with list of numbers, numbers separated into groups
        Groups of numbers are separated by double newlines
        Each number in a group is separated by a newline

    Output: The three largest sums of a group of numbers

    Design in abstract:
        Modification of part 1, track three sums?
            need to always check to replace the lowest one

        Better(?) solution to just have a list of sums, then pick the three largest and add them
        Have a list of sums and a running sums
            if end of block, then stick running sum in list of sums and set running sum to 0
     */
    fun part02(): Int {
        val inputStream = File("./src/main/resources/Day01Input.txt").inputStream()
        var runningSum = 0
        val listOfSums = mutableListOf<Int>()

        inputStream.bufferedReader().forEachLine {
            if(it == "/n" || it.isEmpty()) {
                listOfSums.add(runningSum)
                runningSum = 0
            } else {
                runningSum += it.toInt()
            }
        }

        return listOfSums.sorted().takeLast(3).sum()
    }

    println(part01())
    println(part02())
}