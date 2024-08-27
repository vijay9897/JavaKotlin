package ll

class LL {

    private var head: Node? = null
    private var tail: Node? = null
    var size: Int = 0
    private set

    class Node(val value: Int, var next: Node? = null)

    fun printList() {
        var temp = head
        while (temp != null) {
            print("${temp.value} -> ")
            temp = temp.next
        }
        print("End")
    }

    fun insertFirst(value: Int) {
        val newNode = Node(value)
        if (head == null) {
            head = newNode
            tail = newNode
        } else {
            newNode.next = head
            head = newNode
        }
        size++
    }

    fun reverse() {
        head = reverse(head, null)
    }

    fun oddEvenList() {
        val arr = intArrayOf()
        head ?: return
        head?.next ?: return
        var head1: Node? = head
        var head2: Node? = head?.next
        val secondHead = head2
        var current = head2?.next
        var index = 3
        while(current != null) {
            if(index % 2 == 0) {
                head2?.next = current
                head2 = current
            } else {
                head1?.next = current
                head1 = current
            }
            index++
            current = current?.next
        }
        head2?.next = null
        head1?.next = secondHead
        emptyArray<Node>()
        arrayOf(head)
        arrayOf(10)
    }

    private fun reverse(next: Node?, prev: Node?): Node? {
        if(next?.next == null) {
            return next
        }
        val temp = reverse(next.next, next)
        next.next = prev
        return temp
    }

    fun nextLargerNodes(): IntArray {
        head ?: intArrayOf()
//        val length = findLength(head)
        val result = IntArray(size) {
            0
        }
        val max = head?.value ?: 0
        nextLargeUtil(head, result, 0, max, 0)
        return result
    }

    private fun nextLargeUtil(node: Node?, result: IntArray, index: Int, currMax: Int, prevValue: Int): Int {
        node ?: return 0

        var max = nextLargeUtil(node.next, result, index+1, node.next?.value ?: 0, node.value)
        return if(max > currMax) {
            result[index] = max
            if (currMax > prevValue) {
                currMax
            } else
                max
        } else {
            result[index] = 0
            currMax
        }
    }

}