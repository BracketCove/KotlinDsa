package problems

/*
Notes:
- Array non-empty
- Array has odd number of elements
- Every element will have a pair, except for one unpaired element
- The total number of paired elements can be greater than 2, it just has to be an even number

Goal:
Return the value of the unpaired element
*/

/*
[1, 1, 2, 2, 2, 2, 3]
[1, 1, 2, 2, 2, 2, 2]
[1, 2, 2, 2, 2, 3, 3]

Note: Missing element
*/
fun OOIAsolution(A: IntArray): Int {
    if (A.size == 1) return A[0]

    //sort array first
    A.sort()

    //for each value distinct value, set it as the "target"
    //count occurences of the target until a distinct value is found
    //if the number of occurences is odd, then return that value
    //if we reach the end, odd value must be last value
    var index = 0
    var target = A[0]
    var occurences = 0

    while (index < A.size) {
        if (A[index] == target) occurences++
        else {
            if (occurences % 2 != 0) return target
            target = A[index]
            occurences = 1
        }
        index++
    }

    return A[A.size - 1]
}