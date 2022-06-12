package problems

//Compute the fibonacci sequence up to n levels
fun main() {
   println(fib(10, Array<Int>(11) { 0 }))
}

fun fib(n: Int, memo: Array<Int>) : Int {
    return when {
        n <= 0 -> 0
        n == 1 -> 1
        else -> {
            memo[n] = fib(n - 1, memo) + fib(n - 2, memo)
            memo[n]
        }
    }
}
