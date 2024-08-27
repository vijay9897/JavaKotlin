import java.util.*

fun main() {
//    val arr = intArrayOf(10, 14, 28, 11, 7, 16, 30, 50, 25, 18)
    val arr = intArrayOf(10, 5, 7, 9, 6, 3, 2, 1, 4, 8)
//    val arr = intArrayOf(5, 4, 3, 2, 1)
//    bubbleSortRecursion(arr, 0, 0)
//    selectionSort(arr)
    selectionSortRecursion(arr, arr.size - 1)
//    insertionSort(arr)
//    cyclicSort(arr)
    println(arr.contentToString())
}

fun bubbleSort(arr: IntArray) {
    val length = arr.size
    for (i in 0 until length) {
        var isSwapped = false
        for (j in 1 until length - i) {
            if (arr[j-1] > arr[j]) {
                val temp = arr[j-1]
                arr[j-1] = arr[j]
                arr[j] = temp
                isSwapped = true
            }
        }
        if (!isSwapped)
            break
    }
}

fun selectionSort(arr: IntArray) {
    val length = arr.size
    for (i in 0 until length) {
        var max = arr[0]
        var maxIndex = 0
        for (j in 1 until length - i) {
            if (arr[j] > max) {
                max = arr[j]
                maxIndex = j
            }
        }
        arr[maxIndex] = arr[length - 1 - i]
        arr[length - 1 - i] = max
    }
}

fun insertionSort(arr: IntArray) {
    val length = arr.size
    for (i in 0 until length - 1) {
        var j = i + 1
        while (j > 0) {
            if (arr[j] < arr[j-1]) {
                val temp = arr[j]
                arr[j] = arr[j-1]
                arr[j-1] = temp
            } else {
                break
            }
            j--
        }
    }
}

fun cyclicSort(arr: IntArray) {
    val length = arr.size
    for (i in 0 until length) {
        while (arr[i] != i + 1) {
            val temp = arr[i]
            arr[i] = arr[temp -1]
            arr[temp - 1] = temp
        }
    }
}

fun bubbleSortRecursion(arr: IntArray, row: Int, col: Int) {
    if (row == arr.size) {
        return
    }
    if (col == arr.size - row - 1) {
        bubbleSortRecursion(arr, row + 1, 0)
    } else {
        if (arr[col] > arr[col + 1]) {
            swap(arr, col, col + 1)
        }
        bubbleSortRecursion(arr, row, col + 1)
    }
}

fun selectionSortRecursion(arr: IntArray, row: Int) {
    if (row < 0) {
        return
    }
    val maxIndex = findMax(arr, row)
    swap(arr, maxIndex, row)
    selectionSortRecursion(arr, row - 1)
}

fun findMax(arr: IntArray, col: Int): Int {
    var max = arr[0]
    var maxIndex = 0
    for (i in 1..col) {
        if (max > arr[i]) {
            max = arr[i]
            maxIndex = i
        }
    }
    return maxIndex
}

fun swap(arr: IntArray, first: Int, second: Int) {
    val temp = arr[first]
    arr[first] = arr[second]
    arr[second] = temp
}