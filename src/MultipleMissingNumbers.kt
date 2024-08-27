import java.util.*

fun main() {
    val arr = intArrayOf(4, 3, 2, 7, 8, 2, 3, 1)
    println(sort(arr).toString())
}

fun sort(arr: IntArray): List<Int> {
    var i = 0
    while (i < arr.size) {
        val correctIndex = arr[i] - 1
        if (arr[i] != arr[correctIndex]) {
            val temp = arr[correctIndex]
            arr[correctIndex] = arr[i]
            arr[i] = temp
        } else {
            i++
        }
    }

    val result = arrayListOf<Int>()
    var counter = 0
    for (index in arr.indices) {
        if (index != arr[index] - 1){
            result.add(index + 1)
            counter++
        }
    }
    return result
}