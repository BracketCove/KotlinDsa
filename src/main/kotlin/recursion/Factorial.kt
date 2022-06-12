package recursion

/**
 * n! = n * (n - 1) * (n - 2)..* 1
 */
fun main() {
    println(factorial(3))
}
private fun factorial(n: Int) : Int {

    if (n == 0 ) return 1
    else return n * factorial(n - 1)
}