package LinkedList

fun main() {
    val list = MyLinkedList<Int>()

    list.addLast(1)
    list.addFirst(2)
    list.addFirst(2)
    list.addFirst(2)
    list.addFirst(2)
    list.addFirst(2)
    list.addFirst(2)
    list.removeFirst()
    list.removeLast()

    list.addFirst(1)

    println("${list.getFirst()}  ${list.getLast()}")
}