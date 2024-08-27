import ll.LL
import kotlin.random.Random

fun main() {
    val  list = LL()
    list.insertFirst(5)
    list.insertFirst(3)
    list.insertFirst(4)
    list.insertFirst(7)
    list.insertFirst(2)
//    list.insertFirst(5)
//    list.insertFirst(7)
//    list.insertFirst(1)

    list.printList()

//    list.reverse()
//
//    println()
//    list.printList()
    println()
    print(list.nextLargerNodes().contentToString())

    /*to delete*/
//    val str = "Vijay"
//    val str2 = "vijay"
//    println(str.equals(str2, true))
}