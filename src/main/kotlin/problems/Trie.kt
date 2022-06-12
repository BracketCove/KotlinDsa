package com.example.dsa

fun main() {
    val testWordOne = "car"
    val testWordTwo = "card"
    val trie = Trie(dictionary = arrayOf(testWordOne, testWordTwo))

    val c = trie.root.children['c']
    val a = trie.root.children.get('c')!!.children.get('a')
    val r = trie.root.children.get('c')!!.children.get('a')!!.children.get('r')
    val d = trie.root.children.get('c')!!.children.get('a')!!.children.get('r')!!.children.get('d')

    if (c != null) println(c.value) else println("Failure")
    if (a != null) println(a.value) else println("Failure")
    if (r != null) println(r.value) else println("Failure")
    if (d != null) println(d.value) else println("Failure")
    if (r!!.terminates) println("Success") else println("Failure")
    if (d!!.terminates) println("Success") else println("Failure")


    if (trie.contains("car", false)) println("Success") else println("Failure")
    if (trie.contains("car", true)) println("Success") else println("Failure")
}

class Trie(
    val root: TrieNode = TrieNode(value = '$'),
    val dictionary: Array<String>
) {

    init {
        dictionary.forEach { word -> root.addWord(word) }
    }

    /**
     * Starting from root, begin traversing the Trie where index represents the char in target string.
     * If the given target prefix does not match all values in the trie, return false
     * If exact is false but all chars matched, return true
     * If exact is true and lastNode was terminal, return true else return false
     */
    fun contains(target: String, exact: Boolean): Boolean {
        var lastNode: TrieNode? = root
        var index = 0
        while (index < target.length) {
            lastNode = lastNode?.children?.get(target[index])
            if (lastNode == null) return false
            index ++
        }

        return if (!exact) true else lastNode!!.terminates
    }
}

class TrieNode(
    val children: HashMap<Char, TrieNode> = HashMap(),
    var terminates: Boolean = false,
    val value: Char
) {
    /**
     * add this word to the Trie:
     * - let word be the remaining characters to be added to the Trie
     * - if word is length 0, return
     * - let letter be the first letter in word
     * - this is the current TrieNode in the Trie
     * - if current node does not have letter as a child:
     *      - let child be a TrieNode with letter as its value
     *      - add child to current's children at hash letter
     *  - if word.length = 1 then set child terminates = true
     *  - else call addWord on child with the first char in letter removed
     */
    fun addWord(word: String) {
        if (word.length == 0) return

        val letter = word.first()

        var child = this.children.get(letter)
        if (child == null) {
            child = TrieNode(value = letter)
            this.children.put(letter, child)
        }

        if (word.length == 1) child.terminates = true
        else child.addWord(word.drop(1))
    }
}

