package problems

//Currently this solution is very suboptimal for Performance, and not 100% complete
/*
    Notes:
    - A Tripliet is three distinct elements of the array
    - The triplet is triangular if 0 <= P < Q < R < N
        AND:
        - A[P] + A[Q] > A[R]
        - A[Q] + A[R] > A[P]
        - A[R] + A[P] > A[Q]
        In other words, if the value of any one corner is less than the sum of the values of the
        other two corners, it passes


    - P Q R are indexes, not values
    - upper bound on N is 100000
    - the integer values are any possible integer value on JVM

    Goals:
    - If not triangular triplet exists, return 0
    - If a triangular triplet exists, return 1

    Idea:
    - If N < 3, return 0
    1. Starting from A[0], look at all possible triplet values where 0 <= P < Q < R < N
    2. For each triplet that passes, apply the following test:
        Take 1st, compare with sum of 2nd and 3rd
        Take 2nd, ...
        Take 3rd ...
    3. If at some point a triplet is found, return immediately


*/
fun solution(A: IntArray): Int {
    if (A.size < 3) return 0

    //allows loop break when we reach the end range
    run breakloop@ {
        A.forEachIndexed { P, _ ->
            if (P == A.size - 2)  return@breakloop
            var Q = P + 1
            var R = Q + 1

            while (Q < R) {
                R = Q + 1
                while (R <= A.size - 1) {
                    if (triangular(A[P], A[Q], A[R])) {
                        return 1
                    } else {
                        R++
                    }
                }
                Q++
            }
        }
    }


    return 0
}

private fun triangular(pVal: Int, qVal: Int, rVal: Int): Boolean {
    if (
        (pVal + qVal) > rVal &&
        (qVal + rVal) > pVal &&
        (rVal + pVal) > qVal
    ) return true
    else return false
}