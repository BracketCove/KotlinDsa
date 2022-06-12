package tree


/**
 * I want an example where I need to traverse the Tree structure to count the number of elements.
 * Example tree
 *                      1
 *              2             3
 *           1  4  5      2   1  6
                        1
 */
fun main() {
    val leftChild = TreeNode(
        value = 2,
        children = mutableListOf(
            TreeNode(
                1,
                mutableListOf()
            ),
            TreeNode(
                4,
                mutableListOf()
            ),
            TreeNode(
                5,
                mutableListOf()
            )
        )
    )

    val rightChild = TreeNode(
        value = 3,
        children = mutableListOf(
            TreeNode(
                2,
                mutableListOf(
                    TreeNode(
                        1,
                        mutableListOf()
                    )
                )
            ),
            TreeNode(
                1,
                mutableListOf()
            ),
            TreeNode(
                6,
                mutableListOf()
            )
        )
    )

    val root = TreeNode(
        1,
        mutableListOf(leftChild, rightChild)
    )

    val findAllOnesTest = findOccurrencesOf(root, 1)
    val findNonExistentTest = findOccurrencesOf(root, 43)

    val answerOne = 4
    val answerTwo = 0

    if (findAllOnesTest == answerOne) println("Success") else println(findAllOnesTest)
    if (findNonExistentTest == answerTwo) println("Success") else println(findAllOnesTest)

}

/**
 * if no occurrences obviously return 0
 * 1. Starting with the root node, and for all nodes:
 *  - let value be the searched value
 *  - let current be the node within the current function call
 *  - if current has no children, then return 1 only if it equals the searched value, otherwise 0
 *  - if current has children, add sum of all calls to findOccurencesOf for all children...
 *  ...as well as if it equals the searched value; in which case add 1
 *
 */
fun findOccurrencesOf(current: TreeNode, value: Int): Int {
    //base case
    val hasOccurrence = if (value == current.value) 1 else 0

    return if (current.children.isEmpty()) {
        hasOccurrence
    } else {
        var occurrenceCounter = 0
        current.children.forEach {
           occurrenceCounter += findOccurrencesOf(it, value)
        }
        hasOccurrence + occurrenceCounter
    }
}

data class TreeNode(
    val value: Int,
    val children: MutableList<TreeNode>
)