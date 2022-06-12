package stack


/**
 * Note: returning 0 if null isn't necessarily a good idea.
 */
class Stack {
    private var top: Node? = null

    private inner class Node(
        var data: Int,
        var next: Node? = null
    )

    fun isEmpty(): Boolean = top == null
    fun peek(): Int {
        if (!isEmpty()) return top!!.data
        else return 0
    }

    fun push(data: Int) {
        val node = Node(data)
        node.next = top
        top = node
    }

    fun pop(): Int {
        if (top == null) {
            return 0
        } else {
            val topVal = top!!.data
            top = top!!.next
            return topVal
        }
    }


}