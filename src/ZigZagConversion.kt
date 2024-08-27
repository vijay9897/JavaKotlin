fun main() {
    println(zigZagConversion("PAYPALISHIRING", 4))
}

fun zigZagConversion(str: String, k: Int): String {
    val list = ArrayList<ArrayList<Char>>()
    var index = 0
    var colCounter = 0
    var colMultiplier = 0
    val length = str.length
    Int.MAX_VALUE
    while (index < length) {
        val arr = arrayListOf<Char>()
        var rowCounter = 0
        while(rowCounter < k && index < length) {
            if (colCounter == ((k-1) * colMultiplier)) {
                arr.add(str[index])
                index++
            } else {
                if (rowCounter == k - 1 - (colCounter % (k-1))) {
                    arr.add(str[index])
                    index++
                } else {
                    arr.add(' ')
                }
            }
            rowCounter++
        }
        if (colCounter == ((k-1) * colMultiplier)) {
            colMultiplier++
        }
        list.add(arr)
        colCounter++
    }
    val sb = StringBuilder()
    for (i in 0 until k) {
        for (j in 0 until list.size) {
            if (i < list[j].size && list[j][i] != ' ') {
                sb.append(list[j][i])
            }
        }
    }
    return sb.toString()
}