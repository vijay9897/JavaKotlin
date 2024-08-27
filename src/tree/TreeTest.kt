package tree

fun main() {
//    val arr = intArrayOf(1, 2, 3, 4, 5, 6, 7, -1, -1, -1, -1, -1, -1, -1, -1)
//    val arr = intArrayOf(1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1)
//    val arr = intArrayOf(3, 9, -1, -1, 20, 15, -1, -1, 7, -1,-1)
//    val arr = intArrayOf()
//    val arr = intArrayOf(1, 7, 7, -1, -1, -8, -1, -1, 0, -1, -1)
    /*maximum level sum example*/
//    val arr = intArrayOf(-100, -200, -20, -1, -1, -5, -1, -1, -300, -10, -1, -1, -1)
    /*Increasing order Search tree*/
    val arr = intArrayOf(5, 3, 2, 1, -1, -1, -1, 4, -1, -1, 6, -1, 8, 7, -1, -1, 9, -1, -1)
    val binaryTree = BinaryTree()
//    val rootNode = binaryTree.constructTree(arr, 0)
    val rootNode = binaryTree.constructTree2(arr)
//    print("Pre Order:")
//    binaryTree.preOrderTraversal(rootNode)
//    println()
//    print("In Order:")
//    binaryTree.inOrderTraversal(rootNode)
//    println()
//    print("Post Order:")
//    binaryTree.postOrderTraversal(rootNode)
//    println()
//    print("Level Order:")
//    binaryTree.levelOrderTraversal(rootNode)
//    println()
//    print("Spiral Traversal:")
//    binaryTree.spiralTraversal(rootNode)
//    println(binaryTree.minimumLevelMaximumSum(rootNode))
//    val newNode = binaryTree.increasingBST(rootNode)
    val newRoot = binaryTree.increasingBST(rootNode)
    binaryTree.inOrderTraversal(newRoot)
}