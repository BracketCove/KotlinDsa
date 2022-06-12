package tree

fun main() {
    val tree = Node(null, null, 20)

    tree.insert(15)//left
    tree.insert(26)
    tree.insert(21)
    tree.insert(12)//left


    println(
        tree.contains(20)
    )
}

/**
 * A Binary search tree fulfulls the following conditions:
 * For any given node, it's left child (if one exists) must have a value less than or equal
 * to itself. For right children, the rule is reversed to greater than or equal.
 *
 * Balanced vs Unbalanced:
 * An Unbalanced tree has a higher proportion of either left or right nodes.
 * In an absolute worst case scenario, the time to find an element in the tree would be O(n) runtime complexity
 */
data class Node(
    val left: Node?,
    val right: Node?,
    val value: Int
){
    fun insert(value: Int) {
        if (value <= this.value) {
            if (this.left == null) this.left == Node(null, null, value)
            else this.left.insert(value)
        } else {
            if (this.right == null) this.right == Node(null, null, value)
            else this.right.insert(value)
        }
    }

    fun contains(value: Int): Boolean {
        println(this.value)
        if (value == this.value) return true

        if (value < this.value) {
            if (this.left == null) return false
            else return this.left.contains(value)
        } else {
            if (this.right == null) return false
            else return this.right.contains(value)
        }
    }

    fun printInOrder() {
        if (left != null) left.printInOrder()
        println(value)
        if (right != null) right.printInOrder()
    }
}




private fun dsf(value: Int, current: Node?): Node? {

    return when {
        current == null -> null
        current.value == value -> return current
        current.left != null -> {
            return if (value < current.left.value) {
                dsf(value, current.left)
            } else {
                dsf(value, current.right)
            }
        }
        current.right != null -> {
            return if (current.right.value < value) {
                current.right
            } else {
                current.left
            }
        }
        else -> null

    }
}

