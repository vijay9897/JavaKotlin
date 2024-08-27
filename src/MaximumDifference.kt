fun main() {
 val arr = intArrayOf(1, 2, 90, 10, 110)
    println(findMaximumDifference(arr, arr.size))
}

fun findMaximumDifference(arr: IntArray, n: Int): Int {
    var maxDiff = arr[1] - arr[0]
    var min = arr[0]

    var i = 1
    while (i < n) {
        if(arr[i] - min > maxDiff) {
            maxDiff = arr[i] - min
        }
        if (arr[i] < min) {
            min = arr[i]
        }
        i++
    }
    return maxDiff
}