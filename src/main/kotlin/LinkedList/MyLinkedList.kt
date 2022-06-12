package LinkedList

/**
 * Concept
 * A collection which contains a reference to the first (head) and last (tail) elements in the collection.
 * Each element is a node which contains a value and a reference to the next node.
 *
 *
 * Variations:
 * Doubly LinkedList -> Each node has both next and previous
 * Circular LinkedList -> Head references Tail as previous, Tail references Head as next
 * */

class ListNode<TYPE>(
    var value: TYPE,
    var next: ListNode<TYPE>?
)

class MyLinkedList<TYPE> {
    private var head: ListNode<TYPE>? = null
    private var tail: ListNode<TYPE>? = null

    fun getFirst(): TYPE? {
        if (head != null) return head!!.value
        else return head
    }

    fun getLast(): TYPE? {
        if (tail != null) return tail!!.value
        if (head != null) return head!!.value
        else return null
    }

    //TODO test that the old head is added properly
    fun addFirst(value: TYPE) {
        if (head == null) head = ListNode(value, null)
        else if (tail == null) {
            tail = head
            head = ListNode(value, tail)
            head!!.next = tail
        } else {
            head = ListNode(value, head)
        }
    }

    fun addLast(value: TYPE) {
        if (head == null) head = ListNode(value, tail)
        else if (tail == null) {
            tail = ListNode(value, null)
            head!!.next = tail
        } else {
            tail!!.next = ListNode(value, null)
            tail = tail!!.next
        }
    }

    fun removeLast() {
        if (head == null) Unit
        else if (tail == null) {
            head = null
        } else {
            tail = null
        }
    }

    fun removeFirst() {
        if (head == null) Unit
        else if (tail == null) {
            head = null
        } else {
            head = head!!.next
            if (head == tail) tail = null
        }
    }
}