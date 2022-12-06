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

//region Day 04
fun String.getElfRanges(): Pair<IntRange, IntRange> {
    //format is x-x,x-x
    val ranges = this.split(',')
    val range1 = ranges[0].split('-')
    val range2 = ranges[1].split('-')

    return Pair(range1[0].toInt()..range1[1].toInt(), range2[0].toInt()..range2[1].toInt())
}

fun IntRange.contains(rangeOfInts: IntRange): Boolean {
    // range a-b, c-d
    // a <= c, b >= d

    return (this.first <= rangeOfInts.first && this.last >= rangeOfInts.last)

}
//endregion

//region Day05
typealias FreightStacks = MutableList<ArrayDeque<Char>>
typealias CraneMove = Triple<Int, Int, Int> //first is how many to move, second is from where, third is to where
fun String.parseCraneMove(): CraneMove {
    //format is "move x from y to z"
    val nums = this.split("[a-zA-Z]+".toRegex())
    return CraneMove(nums[1].trim().toInt(), nums[2].trim().toInt(), nums[3].trim().toInt())
}

fun FreightStacks.moveFreight(craneMovements: CraneMove) {
    for(i in 1..craneMovements.first) {
        val removedBox = this[craneMovements.second-1].removeFirst()
        this[craneMovements.third-1].addFirst(removedBox)
    }
}

fun FreightStacks.moveFreightV2(craneMovements: CraneMove) {
    val removedBoxes = this[craneMovements.second-1].take(craneMovements.first)
    for(i in 1..craneMovements.first) {
        this[craneMovements.second-1].removeFirst()
    }
    removedBoxes.asReversed().forEach {
        this[craneMovements.third-1].addFirst(it)
    }
}
//endregion