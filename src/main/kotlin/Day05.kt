import java.io.File

fun main() {

    val stack1 = "NQLSCZPT".toCharArray()
    val stack2 = "GCHVTPL".toCharArray()
    val stack3 = "FZCD".toCharArray()
    val stack4 = "CVMLDTWG".toCharArray()
    val stack5 = "CWP".toCharArray()
    val stack6 = "ZSTCDJFP".toCharArray()
    val stack7 = "DBGWV".toCharArray()
    val stack8 = "WHQSJN".toCharArray()
    val stack9 = "VLSFQCR".toCharArray()

    fun freightStacks() = mutableListOf(
        ArrayDeque(stack1.toMutableList()),
        ArrayDeque(stack2.toMutableList()),
        ArrayDeque(stack3.toMutableList()),
        ArrayDeque(stack4.toMutableList()),
        ArrayDeque(stack5.toMutableList()),
        ArrayDeque(stack6.toMutableList()),
        ArrayDeque(stack7.toMutableList()),
        ArrayDeque(stack8.toMutableList()),
        ArrayDeque(stack9.toMutableList())
    )

    fun part01(): FreightStacks {
        val inputStream = File("./src/main/resources/Day05Input.txt").inputStream()
        val stacks = freightStacks()

        inputStream.bufferedReader().forEachLine { instruction ->
            val craneMovement = instruction.parseCraneMove()
            stacks.moveFreight(craneMovement)
        }

        return stacks

    }

    fun part02(): FreightStacks {
        val inputStream = File("./src/main/resources/Day05Input.txt").inputStream()
        val stacks = freightStacks()

        inputStream.bufferedReader().forEachLine { instruction ->
            val craneMovement = instruction.parseCraneMove()
            stacks.moveFreightV2(craneMovement)
        }

        return stacks
    }

    println(part01())
    println(part02())

}