import java.text.SimpleDateFormat
import kotlin.properties.Delegates

//fun main() {
//    val highScores = listOf(4000, 2000, 10200, 12000, 9030)
//    highScores.withIndex().forEach {
//        println(it)
//    }
//    println(::add.invoke(5, 4))
//    1..6
//    1 until 6
//    val a = 2
//    val b = 3
//    Delegates.vetoable()
//}

class SpecialFunction : () -> Unit {
    override fun invoke() {
        println("Invoked from an instance.")
    }
}
fun main() {
//    try { SpecialFunction()() }
//    catch (ex: Exception) { println("An error occurred") }
//    val str = "0303"
//    str.toInt(2)
//    val sdf1 = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
//    var date = ""
//    try {
//        date = sdf1.format(sdf1.parse("0000-00-00 00:00:00"))
//    } catch (e: Exception) {
//        e.printStackTrace()
//    }
//    println(date)
    val number = "23580"
    println(number.toDouble().toInt())
}

fun add(a: Int, b: Int): Int {
    return a + b
}