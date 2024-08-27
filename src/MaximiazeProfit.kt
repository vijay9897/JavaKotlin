import kotlin.math.min

fun main() {
    val price = intArrayOf(100, 180, 260, 310, 40, 535, 695)
//    val price = intArrayOf(4, 2, 2, 2, 4)
    println(maximumProfit(price, price.size))
}

fun maximumProfit(price: IntArray, start: Int, end: Int): Int {
    if (end <= start) {
        return 0
    }

    var profit = 0

    for (i in start until end) {
        for (j in i+1..end) {
            if (price[j] > price[i]) {
                val currProfit = price[j] - price[i] + maximumProfit(price, start, i - 1) + maximumProfit(price, j + 1, end)
                profit = profit.coerceAtLeast(currProfit)
            }
        }
    }
    return profit
}

fun maximumProfit(price: IntArray, n: Int): Int {

    price.sort()

    if (n <= 1) return 0

    val result = ArrayList<Pair<Int, Int>>()
    var count = 0
    var i = 0
    while ( i < n-1) {
        while (i < n-1 && price[i] >= price[i+1]) {
            i++
        }

        val minima = i++

        while (i < n && price[i] >= price[i-1]) {
            i++
        }

        val pair = Pair(minima, i-1)
        result.add(pair)
        count++
    }

    val hash = HashMap<Int, Int>()
    hash.forEach { i, i2 ->

    }

    var profit = 0
    for (pair in result) {
        profit += (price[pair.second] - price[pair.first])
    }
    return profit

}