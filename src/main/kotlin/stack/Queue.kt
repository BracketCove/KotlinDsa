package stack

fun main() {
    val testQueue = Queue()

    testQueue.add(1)
    testQueue.add(2)
    testQueue.add(3)

    println("${testQueue.remove()} ${testQueue.remove()} ${testQueue.remove()}")
    println("${testQueue.isEmpty()}")

}

/**
 * Note: returning 0 if null isn't necessarily a good idea.
 */
class Queue() {
    private var head: Node? = null
    private var tail: Node? = null

    fun isEmpty(): Boolean {
        return head == null
    }

    fun peek(): Int {
        return if (head == null) 0
        else head!!.data
    }

    fun add(data: Int) {
        val newNode = Node(data)

        when {
            head == null -> head = newNode
            tail == null -> {
                tail = newNode
                head!!.next = tail
            }
            else -> {
                tail!!.next = newNode
                tail = tail!!.next
            }
        }
    }

    fun remove(): Int {
        when {
            head == null -> {
                tail = null
                return 0
            }
            tail == null -> {
                val headData = head!!.data
                head = null
                return headData
            }
            else -> {
                val headData = head!!.data
                head = head!!.next
                return headData
            }
        }
    }


    private inner class Node(
        var data: Int,
        var next: Node? = null
    )
}