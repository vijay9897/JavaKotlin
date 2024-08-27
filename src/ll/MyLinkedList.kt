package ll

import java.lang.reflect.Method
import kotlin.reflect.jvm.javaMethod

class MyLinkedList() {

    private var head: Node? = null
    private var tail: Node? = null
    var size = 0

    class Node(val value: Int) {
        var next: Node? = null
    }

    fun get(index: Int): Int {
        head ?: return -1
        if(index >= size) {
            return -1
        }
        var counter = 0
        var current = head
        while(counter < index && current != null) {
            current = current?.next
            counter++
        }
        return current?.value ?: -1
    }

    fun addAtHead(`val`: Int) {
        val node = Node(`val`)
        if(head == null) {
            head = node
            tail = head
        } else {
            node?.next = head
            head = node
        }
        size++
    }

    fun addAtTail(`val`: Int) {
        val node = Node(`val`)
        if(tail == null) {
            head = node
            tail = head
        } else {
            tail?.next = node
            tail = node
        }
        size++
    }

    fun addAtIndex(index: Int, `val`: Int) {
        if(index > size) {
            return
        }
        if(index == 0) {
            addAtHead(`val`)
            return
        }
        if(index == size) {
            addAtTail(`val`)
            return
        }
        var counter = 0
        var current = head
        while(counter < index - 1) {
            current = current?.next
            counter++
        }
        val node = Node(`val`)
        node.next = current?.next
        current?.next = node
        size++
    }

    fun deleteAtIndex(index: Int) {
        head ?: return
        if(index < 0 || index >= size) {
            return
        }
        if(index == 0) {
            head = head?.next
            return
        }
        var current = head
        var prev: Node? = null
        var counter = 0

        while(counter < index && current != null) {
            prev = current
            current = current?.next
            counter++
        }
        if(current?.next == null) {
            prev?.next = null
            tail = prev
        } else {
            prev?.next = current?.next
        }
        size--
    }

    fun printList() {
        var current = head
        var index = 0
        while (current != null) {
            print("${current.value}($index) ->")
            current =  current?.next
            index++
        }
        print("tail(${tail?.value}) -> End($size)")
        println()
    }

}

fun main() {
    val functionsList = listOf<String>("addAtHead","addAtIndex","addAtTail","addAtTail","addAtTail","addAtIndex","addAtTail",
        "addAtHead","deleteAtIndex","deleteAtIndex","deleteAtIndex","addAtIndex","addAtTail","get","get","addAtHead","addAtTail","addAtTail","get","addAtTail",
        "addAtTail","deleteAtIndex","deleteAtIndex","addAtHead","addAtTail","addAtIndex","get","addAtTail","addAtIndex","addAtHead","addAtTail","addAtIndex","get",
        "addAtHead","addAtTail","addAtIndex","addAtHead","addAtIndex","addAtTail","addAtHead","addAtIndex","addAtTail","addAtHead","deleteAtIndex","get","addAtIndex",
        "get","addAtIndex","addAtTail","addAtTail","get","deleteAtIndex","get","addAtHead","addAtTail","addAtIndex","addAtIndex","addAtIndex","addAtHead","addAtTail",
        "addAtIndex","deleteAtIndex","addAtHead","addAtHead","addAtTail","get","addAtTail","addAtIndex","addAtHead","deleteAtIndex","addAtHead","deleteAtIndex","get","get",
        "addAtTail","addAtIndex","get","deleteAtIndex","deleteAtIndex","addAtHead","addAtHead","addAtIndex","get","addAtTail","addAtHead","addAtIndex","get","addAtHead",
        "deleteAtIndex","deleteAtIndex","deleteAtIndex","addAtHead","addAtTail","get","addAtHead","addAtTail","addAtHead","addAtHead","deleteAtIndex","get","addAtHead"
    )

    val functionInput = arrayListOf<List<Int>>(
        listOf(55),listOf(1,90),listOf(51),listOf(91),listOf(12),listOf(2,72),listOf(17),listOf(82),listOf(4),listOf(7),listOf(7),listOf(5,75),
        listOf(54),listOf(6),listOf(2),listOf(8),listOf(35),listOf(36),listOf(10),listOf(40),listOf(43),listOf(12),listOf(3),listOf(78),listOf(89),listOf(3,41),
        listOf(10),listOf(96), listOf(5,37),listOf(51),listOf(26),listOf(16,91),listOf(18),listOf(11),listOf(66),listOf(22,20),listOf(44),listOf(17,16),
        listOf(95),listOf(2),listOf(14,2),listOf(99),listOf(51),listOf(1),listOf(11),listOf(22,99),listOf(20),listOf(25,42),listOf(72),listOf(45),listOf(2),listOf(4),
        listOf(32),listOf(55),listOf(84),listOf(32,64),listOf(26,14),listOf(30,80),listOf(88),listOf(51),listOf(27,71),listOf(15),listOf(8),listOf(60),listOf(37),
        listOf(25),listOf(96),listOf(25,53),listOf(36),listOf(8),listOf(85),listOf(42),listOf(20),listOf(34),listOf(78),listOf(42,76),listOf(26),listOf(30),listOf(39),
        listOf(27),listOf(93),listOf(19,75), listOf(8),listOf(24),listOf(32),listOf(25,98),listOf(21),listOf(95),listOf(18),listOf(45),listOf(24),listOf(38),listOf(8),
        listOf(20),listOf(83),listOf(71),listOf(78),listOf(55),listOf(29),listOf(11),listOf(84)
    )
    val mLL = MyLinkedList()
    val methodsList = listOf(mLL::addAtHead, mLL::addAtIndex, mLL::addAtTail, mLL::get, mLL::deleteAtIndex).associateBy { it.name }
    functionsList.forEachIndexed { index, s ->
        when(s) {
            "addAtHead" -> {
                val input = functionInput[index][0]
                methodsList[s]?.call(input)
                print("$s($input): ")
                mLL.printList()
            }
            "addAtIndex", -> {
                val input1 = functionInput[index][0]
                val input2 = functionInput[index][1]
                methodsList[s]?.call(input1, input2)
                print("$s($input1, $input2): ")
                mLL.printList()
            }
            "addAtTail" -> {
                val input = functionInput[index][0]
                methodsList[s]?.call(input)
                print("$s($input): ")
                mLL.printList()
            }
            "deleteAtIndex" -> {
                val input = functionInput[index][0]
                methodsList[s]?.call(input)
                print("$s($input): ")
                mLL.printList()
            }
            "get" -> {
                val input = functionInput[index][0]
                print("$s($input): ")
                print(methodsList[s]?.call(input))
                println()
            }
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * var obj = MyLinkedList()
 * var param_1 = obj.get(index)
 * obj.addAtHead(`val`)
 * obj.addAtTail(`val`)
 * obj.addAtIndex(index,`val`)
 * obj.deleteAtIndex(index)
 */