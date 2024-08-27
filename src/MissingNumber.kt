fun main() {
    val arr = intArrayOf(9,6,4,2,3,5,7,0,1)
    val n = arr.size

    val actualSum = (n * (n + 1)) / 2
    var totalSum = 0
    for (i in 0 until n) {
        totalSum += arr[i]
    }
    println(actualSum - totalSum)

}