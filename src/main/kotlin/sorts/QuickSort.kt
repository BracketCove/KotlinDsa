package sorts

import java.util.Collections.swap
import kotlin.random.Random


/**
 * 1. Pick a random "pivot element"
 * 2. Set up two "pointers", left and right
 * 3. starting in two directions from arr[0] to arr[n - 1]
 * 4. Advance left and/or right while they point to a sorted (by pivot) element
 * 5. When left and right point to unsorted elements, swap them
 * 6. When left and right meet, call quicksort again with arr[0] - left, left + 1 to right
 * 7. Base case: if left = right, terminate
 */
fun main() {
    val testArray = arrayOf(1, 9999, 45, 3, 8000, 7, 600, 4500, 10, 7, 7, 900)
    val resultArray = arrayOf(1, 3, 7, 7, 7, 10, 45, 600, 900, 4500, 8000, 9999)

    //val testArray = arrayOf(2, 1, 4, 3)
   // val resultArray = arrayOf(1, 2, 3, 4)

    qs(testArray)

    testArray.forEach { println(it) }

    println(
        testArray contentEquals resultArray
    )
}

fun quickSort(arr: Array<Int>) {
    if (arr.isEmpty() || arr.size == 1) return
    quickSort(0, arr.size - 1, arr)
}


/**
 * 1. Begin with left as index 0 of the array, and right as arr.size - 1
 * 2. Determine the partition of the array (see partition)
 * 3. if the left pointer is less that the partition index - 1, then sort that half
 * 4. if the index is less than the right pointer, sort that half
 */
fun quickSort(left: Int, right: Int, arr: Array<Int>) {
    val index = partition(left, right, arr)

    if (left < index - 1) {
        quickSort(left, index - 1, arr)
    }

    if (index < right) {
        quickSort(index, right, arr)
    }
}

/**
 * 1. Determine the pivot by choosing the middle element
 * 2. while left pointer is less than or equal to the right pointer:
 *  - move left pointer forward until it is greater than or equal to the pivot
 *  - move right pointer backward until it is less than or equal to the pivot
 *  - if the left index is less than or equal to the right index, swap them
 *  - advance both (left++ right--)
 *  3. return the left pointer
 */
fun partition(leftStart: Int, rightEnd: Int, arr: Array<Int>): Int {
    val pivot = arr[leftStart + (rightEnd-leftStart)/2]
    var left = leftStart
    var right = rightEnd
    while (left <= right) {
        while (arr[left] < pivot) left++
        while (arr[right] > pivot) right--

        if (left <= right) {
            val rightVal = arr[right]
            arr[right] = arr[left]
            arr[left] = rightVal

            left++
            right--
        }
    }

    return left
}



/**
 * 1. Begin with left as index 0 of the array, and right as arr.size - 1
 * 2. Determine the partition of the array (see partition)
 * 3. if the left pointer is less that the partition index - 1, then sort that half
 * 4. if the index is less than the right pointer, sort that half
 */
fun qs(arr: Array<Int>){
    qs(0, arr.size - 1, arr)
}

fun qs(left: Int, right: Int, arr: Array<Int>) {
    val index = part(left, right, arr)

    if (left < index - 1) qs(left, index - 1, arr)
    if (index < right) qs(index, right, arr)
}

/**
 * 1. Determine the pivot by choosing the middle element
 * 2. while left pointer is less than or equal to the right pointer:
 *  - move left pointer forward until it is greater than or equal to the pivot
 *  - move right pointer backward until it is less than or equal to the pivot
 *  - if the left index is less than or equal to the right index, swap them
 *  - advance both (left++ right--)
 *  3. return the left pointer
 */
fun part(leftStart: Int, rightEnd: Int, arr: Array<Int>): Int {
    val pivot = arr[leftStart + (rightEnd - leftStart)/2]

    var left = leftStart
    var right = rightEnd

    while (left <= right) {
        while(arr[left] < pivot) left++
        while (arr[right] > pivot) right--

        if (left <= right) {
            val leftVal = arr[left]
            arr[left] = arr[right]
            arr[right] = leftVal

            left++
            right--
        }
    }

    return left
}