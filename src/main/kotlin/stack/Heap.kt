package stack

/**
 * Heap structure created from an Array
 *
 * Insertion occurs top to bottom, left to right
 *
 * Example: 16 14 10 8 7 9 3 2 4 1
 *
 *                      16
 *                 14         10
 *            8       7     9      3
 *          2   4   1
 *
 *           Indexes visualised as a tree:
 *                      1
 *                 2          3
 *               4   5       6   7...
 */
fun main() {
    val heap = Heap(30)
    heap.insert(16)
    heap.insert(14)
    heap.insert(10)
    heap.insert(8)
    heap.insert(7)
    heap.insert(9)
    heap.insert(3)

}

/**
 * Min-Heap property: The smallest value is the top of the heap.
 * Note that this heap assumes positive values.
 */
class Heap(
    val capacity: Int
    ) {
    private var heap = Array<Int>(capacity) { 0 }

    /**
     * DOES NOT REMOVE FROM THE STRUCTURE
     */
    fun getTop():Int = heap[0]

    /**
     * Always insert element at bottom. For the purpose of this example, this will just be at the first location
     * which is equal to 0
     */
    fun insert(value: Int) {
        var index = 0
        while (heap[index] != 0) index++
        heap[index] = value
    }

    fun extractTop(): Int {
        return 0
    }

}







