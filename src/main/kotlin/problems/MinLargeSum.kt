package problems

/*
Given integers M, B, and Array A of size N, where:
M is the largest allowable value of any array element; M is [1..100,000]
B is the number of blocks (array segments) which the array must be split into; though a segment
can be empty
Elements of A are [0..M]
N and K are within [1..100,000]

Find the smallest sum from all possible large sum (block with the largest index) configuration.

Idea:
This problem can be solved using a variation on the binary search algorithm.

Key question:
We can establish the min sum (left) as the largest single value in the array. We can establish the max sum value as the
sum of the array. How is it we know that the answer lies between these values?

 */

import kotlin.math.*
import kotlin.random.Random


fun main() {
    val random = Random
    val M = 10
    val A = intArrayOf(8, 3, 8, 6, 4, 0, 3, 5, 9, 6, 9, 5, 7, 0, 2, 7, 5, 2, 1, 9, 0, 3, 0, 2, 4, 2, 9, 4, 0, 2, 7, 3)
    println(A.joinToString())
    println(A.sum())
   println(solution(5, M, A))
}

fun solution(K: Int, M: Int, A: IntArray): Int {
    //min represents the largest single value in the array.
    var min = 0

    //max represents the sum of the entire array
    var max = A.sum()

    var mid: Int

    //find the largest minimal sum (i.e. the largest single value in the array)
    //and set that as the start
    A.forEach { value ->
        min = Math.max(min, value)
    }

    var minLargeSum = max

    //this means that the start and end of the binary search for sums begins

    //binary search
    while (min <= max) {

        mid = min + (max - min) / 2

        //if this mid point can be used to split A into K blocks
        if (splittable(A, mid, K)) {
            minLargeSum = mid
            max = mid - 1
        } else {
            min = mid + 1
        }

    }

    return minLargeSum
}

/**
 * Here, mid becomes the upper bound on what each block can sum to. If
 */
private fun splittable(A: IntArray, max: Int, K: Int): Boolean {
    var numOfBlocksLeft = K
    var currentSum = 0
    var block = mutableListOf<Int>()

    A.forEach { value ->
        currentSum += value
        block.add(value)
        if (currentSum > max) {
            println(block.joinToString())
            println(currentSum)

            numOfBlocksLeft--
            currentSum = value

            block.clear()
        }

        if (numOfBlocksLeft == 0) {
            println("FALSE")
            return false
        }
    }

    println("TRUE")

    return true
}