package LinkedList

fun main() {
    val testArray = intArrayOf(
        534534,1,5,5,5,123,100,644,2,3,4,55
    )
    topDownMergeSort(
        testArray,
        IntArray(testArray.size),
        0,
        testArray.size - 1
    )

    testArray.forEach {
        println(it)
    }
}

private fun topDownMergeSort(arr: IntArray, temp: IntArray, leftStart: Int, rightEnd: Int) {
    if (leftStart <= rightEnd) return

    val middle = arr[(leftStart + rightEnd) / 2]
    topDownMergeSort(arr, temp, leftStart, middle)
    topDownMergeSort(arr, temp, middle + 1, rightEnd)
    topDownMerge(arr, temp, leftStart, rightEnd)
}

fun topDownMerge(arr: IntArray, temp: IntArray, leftStart: Int, rightEnd: Int) {
    val leftEnd = (leftStart + rightEnd) / 2
    val rightStart = (leftStart + 1)
    val size = rightEnd - leftStart + 1

    var left = leftStart
    var right = rightStart
    var index = leftStart

    while (left <= leftEnd && right <= rightEnd) {
        if (arr[left] <= arr[right]) {
            temp[index] = arr[left]
            left++
        } else {
            temp[index] = arr[right]
            right++
        }

        index++
    }

    System.arraycopy(arr, left, temp, index, leftEnd - left + 1)
    System.arraycopy(arr, right, temp, index, rightEnd - right + 1)
    System.arraycopy(temp, left, arr, leftStart, arr.size)
}




