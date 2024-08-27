import kotlin.math.min

fun main() {
    val edges = arrayOf(intArrayOf(0,1), intArrayOf(0,2), intArrayOf(1,4), intArrayOf(1,5), intArrayOf(2,3),
        intArrayOf(2,6))
    val hasApple = listOf(false,false,true,false,true,true,false)

    println(minTime(7, edges, hasApple))
}

fun minTime(n: Int, edges: Array<IntArray>, hasApple: List<Boolean>): Int {
    var minTime = 0
    for(i in edges.indices) {

    }
    return minTime
}