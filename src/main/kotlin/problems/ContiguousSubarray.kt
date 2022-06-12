package problems

/*
Notes:
- arr[i] must be either the first or last element in a sub-array
- arr[i] is a max, so equal values are permissable

Example:
[1, 2] -> [1], [1] && [1, 2] -> [1, 2]
[3, 3, 3] ->  [3] && [3, 3] && [3, 3, 3] -> [3, 3, 3]
[2, 1, 6, 2, 7]

countSubArrays (arr: IntArray) : IntArray
- let ans be a new IntArray same size as arr, where each index contains the count of contiguous subarrays from arr
- for every element in arr:
  - let midIndex be current index in arr
  - let value be arr[index]
  - let leftIndex be index of the longest subarray in the negative direction, initialized to midIndex - 1
  - let rightIndex be the index of the longest subarray in the positive direction, initialized to midIndex + 1
  - while leftIndex > 0:
        if arr[leftIndex - 1] is less than or equal to value move leftIndex left, else move leftIndex left
        else break
  - while rightIndex < arr.size:
        if arr[rightIndex + 1] is less than or equal to value, move rightIndex right
        else break
  - let count = 1 to account that all indexes have one subarray
  - if leftIndex < midIndex, count += (midIndex - leftIndex)
  - if rightIndex > midIndex, count += (rightIndex - midIndex)
  - ans[midIndex] = count
- return ans

*/

fun main(args: Array<String>) {
    val testOne = countSubarrays(arrayOf(1, 2))
    val testTwo = countSubarrays(arrayOf(3, 3, 3))
    val testThree = countSubarrays(arrayOf(3, 4, 1, 6, 2))

    val ansOne = arrayOf(1, 2)
    val ansTwo = arrayOf(3, 3, 3)
    val ansThree = arrayOf(1, 3, 1, 5, 1)

    println(testOne.joinToString())
    println(testTwo.joinToString())
    println(testThree.joinToString())

}

fun countSubarrays(arr: Array<Int>): Array<Int> {
    val ans = Array<Int>(arr.size) { 0 }

    arr.forEachIndexed { midIndex, value ->
        var leftIndex = midIndex
        var rightIndex = midIndex

        while (leftIndex > 0) {
            if (arr[leftIndex - 1] <= value) leftIndex--
            else break
        }

        while (rightIndex < arr.size - 1) {
            if (arr[rightIndex + 1] <= value) rightIndex++
            else break
        }
        var count = 1

        //       println("$value $leftIndex $rightIndex ")
        if (leftIndex < midIndex) count += midIndex - leftIndex
        if (rightIndex > midIndex) count += rightIndex - midIndex

        ans[midIndex] = count
    }

    return ans
}