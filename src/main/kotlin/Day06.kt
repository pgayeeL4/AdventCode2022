import java.io.File

fun main() {

    /*
    Input: String representing a datastream, made of random characters
    Output: The index of the first character of a four-char sequence that has all distinct chars

    Design in abstract:
        Grab 4 chars at a time
            Check for distinctness
            If so, return index
            if not, step 1 to the next char

        Distinctness check:
            Treat string as char array, turn it into a set, check if length = 4
     */
    fun part01(): Int {
        val inputStream = File("./src/main/resources/Day06Input.txt").inputStream()
        val data = inputStream.bufferedReader().readLine()
        return data.parseElfMarkers(4)
    }

    fun part02(): Int {
        val inputStream = File("./src/main/resources/Day06Input.txt").inputStream()
        val data = inputStream.bufferedReader().readLine()
        return data.parseElfMarkers(14)
    }

    println(part01())
    println(part02())
}