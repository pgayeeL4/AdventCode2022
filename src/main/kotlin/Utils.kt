import java.io.File

//region General
fun makeArrayOfStringsFromFileLines(file: File): List<String> {
    val lines = mutableListOf<String>()
    file.inputStream().bufferedReader().forEachLine {
        lines.add(it)
    }
    return lines
}
//endregion

//region Day 02
fun codeToRPSValue(codedValue: String): RPS {
    return when (codedValue) {
        "A", "X" -> {
            RPS.Rock
        }
        "B", "Y" -> {
            RPS.Paper
        }
        else -> {
            RPS.Scissors
        }
    }
}

fun codeToResultValue(codedValue: String): RPSResult {
    return when (codedValue) {
        "X" -> RPSResult.Loss
        "Y" -> RPSResult.Draw
        else -> RPSResult.Win
    }
}

enum class RPS(val pointValue: Int) {
    Rock(1) {
        override fun play(opponentInput: RPS): RPSResult {
            return when(opponentInput) {
                Rock        -> RPSResult.Draw
                Paper       -> RPSResult.Loss
                Scissors    -> RPSResult.Win
            }
        }

        override fun resultToRPS(result: RPSResult): RPS {
            return when(result) {
                RPSResult.Draw -> Rock
                RPSResult.Win -> Paper
                RPSResult.Loss -> Scissors
            }
        }
    },
    Paper(2) {
        override fun play(opponentInput: RPS): RPSResult {
            return when(opponentInput) {
                Rock        -> RPSResult.Win
                Paper       -> RPSResult.Draw
                Scissors    -> RPSResult.Loss
            }
        }

        override fun resultToRPS(result: RPSResult): RPS {
            return when(result) {
                RPSResult.Draw -> Paper
                RPSResult.Win -> Scissors
                RPSResult.Loss -> Rock
            }
        }
    },
    Scissors(3) {
        override fun play(opponentInput: RPS): RPSResult {
            return when(opponentInput) {
                Rock        -> RPSResult.Loss
                Paper       -> RPSResult.Win
                Scissors    -> RPSResult.Draw
            }
        }

        override fun resultToRPS(result: RPSResult): RPS {
            return when(result) {
                RPSResult.Draw -> Scissors
                RPSResult.Win -> Rock
                RPSResult.Loss -> Paper
            }
        }
    };

    abstract fun play(opponentInput: RPS): RPSResult

    //returns what you should throw vs this to get result
    abstract fun resultToRPS(result: RPSResult): RPS
}

enum class RPSResult(val resultPointValue: Int) {
    Loss(0),
    Draw(3),
    Win(6);
}
//endregion

//region Day 03
fun String.splitStrings(): Pair<CharSequence, CharSequence> {
    val firstHalf = this.subSequence(0, this.length/2)
    val secondHalf = this.subSequence(this.length/2, this.length)
    return Pair(firstHalf, secondHalf)
}

fun Char.asciiSequenceNumber(): Int {
    //return 1-26 for a-z, 27-52 for A-Z
    //this is only for alphabetical letters

    //check if uppercase
    val isUpper = this.isUpperCase()

    //get value as if it's lowercase
    val sequenceNum = this.lowercaseChar().code - 'a'.code + 1
    return if(isUpper) {
        sequenceNum + 26
    } else {
        sequenceNum
    }
}

//endregion