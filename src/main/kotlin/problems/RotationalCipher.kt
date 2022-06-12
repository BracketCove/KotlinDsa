package problems

fun main(args : Array<String>) {
    val testOne = rotationalCipher("Zebra-493", 3)
    println(testOne)
}


fun rotationalCipher(input: String, rotationFactor: Int): String {
    val newString = Array<Char>(input.length) { ' ' }
    val lc = "abcdefghijklmnopqrstuvwxyz"
    val uc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    val nums = "0123456789"

    val rotationsAlpha = if (rotationFactor > lc.length) rotationFactor % lc.length else rotationFactor
    val rotationsNum = if (rotationFactor > nums.length) rotationFactor % nums.length else rotationFactor

    var index = 0

    while (index < input.length) {
        val current = input[index]
        when {
            lc.contains(current) -> {
                val oldIndex = lc.indexOf(current)
                val newIndex = if (oldIndex + rotationsAlpha > lc.length) (oldIndex + rotationsAlpha) - lc.length
                else oldIndex + rotationsAlpha

                newString[index] = lc[newIndex]
            }
            uc.contains(current) -> {
                val oldIndex = uc.indexOf(current)
                val newIndex = if (oldIndex + rotationsAlpha > lc.length) (oldIndex + rotationsAlpha) - lc.length
                else oldIndex + rotationsAlpha

                newString[index] = uc[newIndex]
            }
            nums.contains(current) -> {
                val oldIndex = nums.indexOf(current)
                val newIndex = if (oldIndex + rotationsNum > nums.length) (oldIndex + rotationsNum) - nums.length
                else oldIndex + rotationsNum

                newString[index] = nums[newIndex]
            }
            else -> newString[index] = input[index]
        }

        index++
    }

    return newString.joinToString()
}
