import java.io.File

fun main() {
    /*
    Input: File with lines of characters
        Each line is a different rucksack
        Each character is an item
        The first half is the first compartment of the sack, the second half is the second
        Lowercase letters have a priority value of 1-26, with a being 1 and z being 26
        Uppercase letters have a priority value of 27-52, A being 27 and Z being 52

    Output:
        A sum of priority values of the items that appear in both rucksack compartments per rucksack

    Design in abstract:
        For each line in the file,
            First split the line into two halves
            Second look for the common char between the two
            Third find the priority for the common value and add it to a running sum

        Splitting:
            Trivial
        Find common char:
            For each char in first compartment, check if it's in the second compartment
            If true, then calculate priority for that char
        Priority Value Calculation:
            Flag if capital letter or not
            Convert to ASCII code, subtract the ASCII code for 'a', add 1
            If capital letter, then also add 26
     */

    fun part01(): Int {
        val inputStream = File("./src/main/resources/Day03Input.txt").inputStream()
        var prioritySum = 0

        inputStream.bufferedReader().forEachLine { rucksack ->
            val compartments = rucksack.splitStrings()
            compartments.first.forEach {
                if(compartments.second.contains(it, ignoreCase = false)) {
                    prioritySum += it.asciiSequenceNumber()
                    return@forEachLine
                }
            }
        }
        return prioritySum
    }

    /*
    Take the lines three at a time, each three lines is a group
    Find the common char/item between all three, this is the badge
    Sum up the priority of each badge item across all groups

    Find common char across three strings:
        For each char in first, check second
        if char is in second, then check third
            If in all three, calculate priority
     */
    fun part02(): Int {
        val file = File("./src/main/resources/Day03Input.txt")
        var badgeSum = 0

        val listOfSacks = makeArrayOfStringsFromFileLines(file)

        for(i in listOfSacks.indices step 3) {
            val member1 = listOfSacks[i]
            val member2 = listOfSacks[i+1]
            val member3 = listOfSacks[i+2]
            run {
                member1.forEach {
                    if(member2.contains(it, ignoreCase = false)) {
                        if (member3.contains(it, ignoreCase = false)) {
                            badgeSum += it.asciiSequenceNumber()
                            return@run
                        }
                    }
                }
            }
        }

        return badgeSum
    }

    println(part01())
    println(part02())

}