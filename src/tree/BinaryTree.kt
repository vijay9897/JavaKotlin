package tree

import java.util.*
import kotlin.collections.ArrayList

class BinaryTree {

    companion object {
        var index = -1
    }

    /*Constructing tree from level order traversal*/
    fun constructTree(arr: IntArray, index: Int): TreeNode<Int>? {
        if (arr.isEmpty()) return null

        if (index >= arr.size) {
            return null
        }

        if (arr[index] == -1) {
            return null
        }

        val newNode = TreeNode(arr[index])
        newNode.left = constructTree(arr, 2 * index + 1)
        newNode.right = constructTree(arr, 2 * index + 2)

        return newNode
    }

    /*Constructing tree from pre order traversal*/
    fun constructTree2(arr: IntArray): TreeNode<Int>? {
        if (arr.isEmpty()) return null

        index++
        if (arr[index] == -1) {
            return null
        }

        val newNode = TreeNode(arr[index])
        newNode.left = constructTree2(arr)
        newNode.right = constructTree2(arr)

        return newNode
    }

    fun preOrderTraversal(node: TreeNode<Int>?) {
        if (node == null) {
            return
        }
        print("${node.value} -> ")
        preOrderTraversal(node.left)
        preOrderTraversal(node.right)
    }

    fun inOrderTraversal(node: TreeNode<Int>?) {
        if (node == null) {
            return
        }
        inOrderTraversal(node.left)
        print("${node.value} -> ")
        inOrderTraversal(node.right)
    }

    fun postOrderTraversal(node: TreeNode<Int>?) {
        if (node == null) {
            return
        }
        postOrderTraversal(node.left)
        postOrderTraversal(node.right)
        print("${node.value} -> ")
    }

    fun levelOrderTraversal(node: TreeNode<Int>?) {
        val queue: Queue<TreeNode<Int>>  = LinkedList()
        queue.add(node)
        while (queue.isNotEmpty()) {
            val tempNode = queue.remove()
            print("${tempNode.value} -> ")
            if (tempNode.left != null)
                queue.add(tempNode.left)
            if (tempNode.right != null)
                queue.add(tempNode.right)
        }
    }

    fun spiralTraversal(node: TreeNode<Int>?) {
        val stack1: Stack<TreeNode<Int>> = Stack()
        val stack2: Stack<TreeNode<Int>> = Stack()
        stack1.push(node)
        while (stack1.isNotEmpty() || stack2.isNotEmpty()) {
            while (stack1.isNotEmpty()) {
                val tempNode = stack1.pop()
                print("${tempNode.value} -> ")
                if (tempNode.left != null) {
                    stack2.push(tempNode.left)
                }
                if (tempNode.right != null) {
                    stack2.push(tempNode.right)
                }
            }
            while (stack2.isNotEmpty()) {
                val tempNode = stack2.pop()
                print("${tempNode.value} -> ")
                if (tempNode.right != null) {
                    stack1.push(tempNode.right)
                }
                if (tempNode.left != null) {
                    stack1.push(tempNode.left)
                }
            }
        }
    }

    fun treeHeight(node: TreeNode<Int>?): Int {
        if (node == null) {
            return 0
        }

        val leftHeight = treeHeight(node.left)
        val rightHeight = treeHeight(node.right)

        return leftHeight.coerceAtLeast(rightHeight) + 1
    }

    fun levelOrder(root: TreeNode<Int>?): List<List<Int>> {
        if(root == null) return emptyList()
        val queue: Queue<TreeNode<Int>?> = LinkedList()
        val result = ArrayList<ArrayList<Int>>()
        queue.add(root)
        queue.add(null)

        var tempList = ArrayList<Int>()
        while(queue.isNotEmpty()) {
            val node = queue.remove()
            if(node == null) {
                result.add(tempList)
                tempList = arrayListOf()
                if(queue.isNotEmpty()) {
                    queue.add(null)
                }
            } else {
                tempList.add(node.value)
                if(node.left != null)
                    queue.add(node.left)
                if(node.right != null)
                    queue.add(node.right)
            }
        }

        return result
    }

    fun zigzagLevelOrder(root: TreeNode<Int>?): List<List<Int>> {
        root ?: return emptyList()
        val stack1 = Stack<TreeNode<Int>>()
        val stack2 = Stack<TreeNode<Int>>()
        val result = ArrayList<ArrayList<Int>>()
        stack1.push(root)

        var tempList = ArrayList<Int>()
        while(stack1.isNotEmpty() || stack2.isNotEmpty()) {
            while(stack1.isNotEmpty()) {
                val node = stack1.pop()
                tempList.add(node.value)
                if(node.left != null) {
                    stack2.push(node.left)
                }
                if(node.right != null) {
                    stack2.push(node.right)
                }
            }
            if(tempList.isNotEmpty()) {
                result.add(tempList)
                tempList = arrayListOf()
            }
            while(stack2.isNotEmpty()) {
                val node = stack2.pop()
                tempList.add(node.value)
                if(node.right != null) {
                    stack1.push(node.right)
                }
                if(node.left != null) {
                    stack1.push(node.left)
                }
            }
            if(tempList.isNotEmpty()) {
                result.add(tempList)
                tempList = arrayListOf()
            }
        }
        return result
    }

    fun reverseLevelOrders(root: TreeNode<Int>?) {
        val stack = Stack<TreeNode<Int>>()
        val queue:Queue<TreeNode<Int>> = LinkedList()
        queue.add(root)

        while (queue.isNotEmpty()) {
            val node = queue.remove()
            stack.push(node)
            if (node.right != null) {
                queue.add(node.right)
            }
            if (node.left != null) {
                queue.add(node.left)
            }
        }

        while (stack.isNotEmpty()) {
            val node = stack.pop()
            print("${node.value} -> ")
        }
    }

    fun minimumLevelMaximumSum(root: TreeNode<Int>?): Int {
        if (root == null) return -1

        val queue: Queue<TreeNode<Int>?> = LinkedList()
        queue.add(root)
        queue.add(null)
        var levelSum = 0
        var minimumLevel = -1
        var currentLevel = 1
        var maximumSum = Int.MIN_VALUE
        while (queue.isNotEmpty()) {
            val node = queue.remove()
            if (node == null) {
                if (levelSum > maximumSum) {
                    maximumSum = levelSum
                    minimumLevel = currentLevel
                }
                currentLevel += 1
                levelSum = 0
                if (queue.isNotEmpty()) {
                    queue.add(null)
                }
            } else {
                levelSum += node.value
                if (node.left != null) {
                    queue.add(node.left)
                }
                if (node.right != null) {
                    queue.add(node.right)
                }
            }
        }

        return minimumLevel
    }

    fun increasingBST(root: TreeNode<Int>?): TreeNode<Int>? {
        val result = arrayListOf<Int>()
        getInOrder(root, result)
        if (result.isEmpty()) return null
        val newRoot = TreeNode(result[0])
        var current = newRoot
        for (i in 1 until result.size) {
            val node = TreeNode(result[i])
            current.right = node
            current = node
        }
        return newRoot
    }

    private fun getInOrder(root: TreeNode<Int>?, result: ArrayList<Int>) {
        root ?: return
        getInOrder(root.left, result)
        result.add(root.value)
        getInOrder(root.right, result)
    }
}