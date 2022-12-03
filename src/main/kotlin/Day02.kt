import java.io.File

fun main() {

    /*
    Input: File with list of letter pairs, each pair representing a round of combat
        First element is opponent
        Second element is player
        A/X is Rock, B/Y is Paper, C/Z is Scissors

    Output
        Total player score, calculated as below:
            Rock gives 1, Paper 2, and Scissors 3
            Win gives 6, Draw gives 3, and Loss 0

    Design in abstract:
        Initialize a point sum

        Read in file line by line
        Split line into pairs of strings
        Convert strings into Rock, Paper, or Scissors
        Add player choice points to sum
        Calculate result and add result points to sum
     */
    fun part01(): Int {
        val inputStream = File("./src/main/resources/Day02Input.txt").inputStream()
        var pointSum = 0

        inputStream.bufferedReader().forEachLine { values ->
            val choices = values.split("\\s".toRegex())
            val oppChoice = codeToRPSValue(choices[0])
            val playerChoice = codeToRPSValue(choices[1])

            pointSum += playerChoice.pointValue + playerChoice.play(oppChoice).resultPointValue
        }

        return pointSum
    }

    /*
    First element is opponent choice
    second element is wanted result

    Add wanted result's value to point sum
    if wanted result is draw, then add opponent choice point value to point sum
    else,
     */
    fun part02(): Int {
        val inputStream = File("./src/main/resources/Day02Input.txt").inputStream()
        var pointSum = 0

        inputStream.bufferedReader().forEachLine { values ->
            val choices = values.split("\\s".toRegex())
            val oppChoice = codeToRPSValue(choices[0])
            val wantedResult = codeToResultValue(choices[1])

            pointSum += wantedResult.resultPointValue
            if(wantedResult == RPSResult.Draw) {
                pointSum += oppChoice.pointValue
            } else {
                pointSum += oppChoice.resultToRPS(wantedResult).pointValue
            }

        }

        return pointSum
    }

    println(part01())
    println(part02())



}