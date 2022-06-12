package sorts

import kotlin.math.exp

/**
 * Perform pairwise swaps of the collection.
 *
 * 1. Until array is sorted (i.e. no swaps are necessary on a full pass of the collection):
 * 2. Starting from index 0, compare a[i] and a[i + 1]
 * 3. If a[i] is lesser, move to i + 1
 * 4. if a[i] is greater, swap a[i] with a[i + 1]
 * 5.
 *
 * Example [2, 3, 1, 4] -> [2, 1, 3, 4] -> [1, 2, 3, 4]
 *
 * */
fun main() {
    val testArray = arrayOf(45, 2, 44, 1, 665, 10, 5, 40)
    val expectedResult = arrayOf(1, 2, 5, 10, 40, 44, 45, 665)

    bubbleSort(testArray)
    testArray.forEach { println(it) }
    println(
        testArray contentEquals expectedResult
    )
}

fun bubbleSort(testArray: Array<Int>) {
        var needSwaps = true

    while (needSwaps) {
        var swaps = 0

        testArray.forEachIndexed { index, value ->
            if (index < testArray.size - 1) {
                if (value > testArray[index + 1]) {
                    testArray[index] = testArray[index + 1]
                    testArray[index + 1] = value
                    swaps++
                }
            }
        }

        if (swaps == 0) needSwaps = false
    }
}
