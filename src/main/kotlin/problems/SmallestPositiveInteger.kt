package problems

// you can also use imports, for example:
// import kotlin.math.*

// you can write to stdout for debugging purposes, e.g.
// println("this is a debug message")

const val upperbound = 1000000

fun SPIsolution(A: IntArray): Int {
    val counterMap = mutableMapOf<Int, Int>()

    A.forEach { value ->
        if (value > 0) {
            when {
                counterMap.get(value) == null -> counterMap.set(value, 1)
                else -> {
                    counterMap.set(value, counterMap.get(value)!! + 1)
                }
            }
        }
    }

    if (counterMap.isEmpty()) return 1

    (1..upperbound).forEach {
        if (counterMap.get(it) == null) return it
    }

    return -1
}
