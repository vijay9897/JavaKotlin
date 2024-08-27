fun main() {
    val input = ""
    println(getCombinations("", input))
}

fun getCombinations(p: String, input: String): List<String> {
    if (input.isEmpty()) {
        return listOf(p)
    }
    val ch = input[0]
    val letter = getLettersMapping(ch)
    val result = arrayListOf<String>()
    if (letter.isNotEmpty()) {
        for (i in letter.indices) {
            result.addAll(getCombinations("$p${letter[i]}", input.substring(1, input.length)))
        }
    } else {
        result.addAll(getCombinations(p, input.substring(1, input.length)))
    }
    return result
}

fun getLettersMapping(ch: Char) = when(ch) {
    '2' -> "abc"
    '3' -> "def"
    '4' -> "ghi"
    '5' -> "jkl"
    '6' -> "mno"
    '7' -> "pqrs"
    '8' -> "tuv"
    '9' -> "wxyz"
    else -> ""
}