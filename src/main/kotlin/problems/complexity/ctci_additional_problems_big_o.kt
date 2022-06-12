package problems.complexity

//V1.1
fun product(a: Int, b: Int) : Int {
    //constant
    var sum = 0

    //O(b)
    for (i in 0..b) {
        sum += a
    }

    //constant
    return sum
}
//O(b)

//V1.2
fun power(a: Int, b: Int) : Int {
    //constant
    if (b < 0) {
        return 0
    }
    //constant
    else if (b == 0) {
        return 1
    } else {
        //O(b) i.e. linear to b
        return a * power(a, b - 1)
    }
}
