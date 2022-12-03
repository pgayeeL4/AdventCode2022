
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