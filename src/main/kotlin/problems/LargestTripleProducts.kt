package problems


fun main(args : Array<String>) {
    val testOne = findMaxProduct(arrayOf(1, 2, 3, 4, 5))
    val ansOne = arrayOf(-1, -1, 6, 24, 60)

    val testTwo = findMaxProduct(arrayOf(2, 1, 2, 1, 2))
    val ansTwo = arrayOf(-1, -1, 4, 4, 8)
    if (testOne contentEquals ansOne) println("Success") else println(testOne.joinToString())
    if (testTwo contentEquals ansTwo) println("Success") else println(testTwo.joinToString())
}

fun findMaxProduct(arr: Array<Int>): Array<Int> {
    val ans = Array<Int>(arr.size) { -1 }
    val topThree = Array<Int>(3) { 1 }

    var index = 0
    while(index < arr.size) {
        addIfHigher(arr[index], topThree)
        if (index > 1) ans[index] = topThree[0] * topThree[1] * topThree[2]
        index++
    }

    return ans
}


fun addIfHigher(new: Int, topThree: Array<Int>) {
    when {
        new >= topThree[0] -> {
            val second = topThree[0]
            val third = topThree[1]
            topThree[0] = new
            topThree[1] = second
            topThree[2] = third
        }

        new >= topThree[1] -> {
            val third = topThree[1]
            topThree[1] = new
            topThree[2] = third
        }

        new > topThree[2] -> topThree[2] = new
    }
}
