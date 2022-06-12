package problems

fun main(args : Array<String>) {
    val testOne = getTotalTime(arrayOf(1, 25, 4, 5))
    val ansOne = 99

    val testTwo = getTotalTime(arrayOf(99))
    val ansTwo = 0
    if (testOne == ansOne) println("Success") else println(testOne)
    if (testTwo == ansTwo) println("Success") else println(testTwo)
}

fun getTotalTime(arr: Array<Int>): Int {
    var penalty = 0
    var endIndex = arr.size - 1
    arr.sort()

    while (endIndex > 0) {
        val sum = arr[endIndex] + arr[endIndex - 1]
        penalty += sum
        arr[endIndex - 1] = sum

        endIndex--
    }

    return penalty
}

