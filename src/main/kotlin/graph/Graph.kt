package graph

fun main() {
    val graph = Graph().apply {

    }
}

/**
 * This graph consists of a HashMap, where each element of the HashMap is a Node.
 * Each node contains
 */
class Graph(
    private val adjacencyList: HashMap<Int, Node> = HashMap()
) {

    class Node(
        val key: Int,
        val value: Int,
        val adjacent: MutableList<Node> = mutableListOf()
    )

    fun addNode(key: Int) {

    }
    fun getNode(id: Int) : Node? = adjacencyList[id]
    fun addEdge(source: Int, destination: Int) {
        val s = adjacencyList[source]
        val d = adjacencyList[destination]
        if (s != null && d != null) s.adjacent.add(d)
    }
}