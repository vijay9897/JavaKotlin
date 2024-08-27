fun main() {
    val result = arrayListOf<List<Int>>()
    println(getDiceNumbers("", 4))
//    println(result)
}

fun getDiceNumbers(current: String, target: Int): List<String> {
    if (target == 0) {
        return listOf(current)
    }
    val result = arrayListOf<String>()
    for (i in 1..6) {
        if (i <= target) {
            result.addAll(getDiceNumbers("$current$i", target - i))
        }
    }
    return result
}