fun main() {
    val input = "abcde"
    val result = permutations("", input)
    println(result)
}

fun permutations(p: String, input: String): List<String> {
    if (input.isEmpty()) {
        return listOf(p)
    }
    val ch = input[0]
    val result = arrayListOf<String>()
    for (i in 0..p.length) {
        val newProcessed = "${p.subSequence(0, i)}$ch${p.subSequence(i, p.length)}"
        result.addAll(permutations(newProcessed, input.substring(1, input.length)))
    }
    return result
}