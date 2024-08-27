fun main() {
    val arr = intArrayOf(1, 2, 3, 4, 5)
    println(binarySearch(arr, 0, arr.size - 1, 1))
}

fun binarySearch(array: IntArray, start: Int, end: Int, target: Int): Int {
    if (start > end) {
        return -1
    }
    val mid = start + (end - start) / 2
    return if (array[mid] == target) {
        mid
    } else if (array[mid] < target) {
        binarySearch(array, mid + 1, end, target)
    } else {
        binarySearch(array, start, mid - 1, target)
    }
}