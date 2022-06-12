package problems.complexity

fun foo(array: IntArray) {
    var sum = 0
    var product = 1

    for (i in 0..array.size) {
        sum += array[i]
    }

    for (i in 0..array.size) {
        product *= array[i]
    }

    System.out.println("$sum, $product")
}

fun printPairs(array: IntArray) {
    for (i in 0..array.size) {
        for (j in 0..array.size) {
            println("${array[i]}, ${array[j]}")
        }
    }
}

fun printUnorderedPairs(array: IntArray) {
    for (i in 0..array.size) {
        for (j in (i + 1)..array.size) {
            println("${array[i]}, ${array[j]}")
        }
    }
}

fun printUnorderedPair(arrayA: IntArray, arrayB: IntArray) {
    for (i in 0..arrayA.size) {
        for (j in 0..arrayB.size) {
            if (arrayA[i] < arrayB[j]) {
                println("${arrayA[i]}, ${arrayB[j]}")
            }
        }
    }
}

fun printUnorderedPairDDD(arrayA: IntArray, arrayB: IntArray) {
    for (i in 0..arrayA.size) {
        for (j in 0..arrayB.size) {
            for (k in 0..100000)
                println("${arrayA[i]}, ${arrayB[j]}")
        }
    }
}

fun reverse(array: IntArray) {
    for (i in 0..(array.size/2)) {
        val other = array.size - i - 1
        var temp = array[i]
        array[i] = array[other]
        array[other] = temp
    }
}

class Node(
val value: Int,
val left: Node?,
val right: Node?
)

//Linear
fun sum(node: Node?): Int  {
    if (node == null) return 0
    return sum(node.left) + node.value + sum(node.right)
}

// O(Root(n)). The reason is because we only ever need to reach the square root of N in order to verify
//if it is prime
fun isPrime(n: Int) : Boolean {
    var x = 2
    while (x*x <= n) {
        if (n % x == 0) {
            return false
        }
        x++
    }

    return true
}

/**
 * O(n): Recursion with only one branch is linear unless something else is going on
 */
fun factorial(n: Int): Int {
    if (n < 0) {
        return -1
    } else if (n == 0) {
        return 1
    } else {
        return n * factorial(n - 1)
    }
}


//O(n!)
fun permutation(str: String) {
    permutation(str, "")
}

fun permutation(str: String, prefix: String) {
    if (str.length == 0) {
        //constant
        println(prefix)
    } else {
        //for each character in the String
        //depends on
        for (i in 0..str.length) {

            var rem =
                // create a substring from the start to the index
                // add the substring from i to the next
                //for i = 0 in "derp" == "" + "d"
                str.substring(0, i) + str.substring(i + 1)
            permutation(rem, prefix + str[i])
        }
    }
}