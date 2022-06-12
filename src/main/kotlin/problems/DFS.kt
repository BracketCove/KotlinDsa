package com.example.dsa



class DfsNode(
    val value: Int,
    val adj: List<DfsNode> = emptyList()
)

/**
 * test tree: For ease of testing, keys are in the order I want them to be traversed ideally
 *
 *              1
 *        2             5
 *     3     4       6
 *           ^----7  seven is a cycle to 4
 */
fun main() {

    val root = DfsNode(
        value = 1,
        listOf(
            DfsNode(
                value = 2,
                listOf(
                    DfsNode(3),
                    DfsNode(4)
                )
            ),
            DfsNode(
                value = 5,
                listOf(
                    DfsNode(
                        value = 6,
                        listOf(
                            DfsNode(
                                value = 7,
                                listOf(
                                    DfsNode(4)
                                )
                            )
                        )
                    )
                )
            )
        )
    )

    depthFirstSearch(listOf(root))
}

/**
 * Depth First Search: Rather than traversing a graph level by level, in this case the graph is
 * traversed in a top down fashion
 *
 * Q1: Suppose we are given two nodes and we want to see if we can get from the first to the second.
 * How would we do that using DFS?
 * A1: By performing a DFS on the first node, we could search for the following property:
 *  - if by dfs traversal, we come across the key for the second node, we could return true.
 *  - otherwise, if we never come across second node, then they must not be connected
 *
 * Pseudocode:
 * depthFirstSearch:
 * - let visited be a hashmap which has node keys as keys, and any integer to denote a visited node
 * - let adj be an adjacency list passed in as an argument
 * - let nodes be an array of Nodes that are passed in, that may or may not be connected
 * - for each node in nodes:
 *  - if visited contains node key, then skip
 *  - else:
 *      - set visited at node equal to 1
 *      - call visitAdjacent on nodes adjacent to node
 *
 */
fun depthFirstSearch(rootNodes: List<DfsNode>) {
    val visited = HashMap<Int, Int>()

    rootNodes.forEach{ node ->
        println(node.value)
        if (!visited.containsKey(node.value)) {
            visited.set(node.value, 1)
            visitAdjacent(visited, node.adj)
        }
    }
}

/**
 * visitAdjacent: hashmap visited for visited nodes, adjacency list adj
 * - for every node in adj:
 *  - if visited contains node key, skip
 *  - else:
 *      - set visited at node key to 0
 *      - call visitAdjacent with visited and node.adjacent
 */
fun visitAdjacent(visited: java.util.HashMap<Int, Int>, adj: List<DfsNode>) {
    adj.forEach { node ->
        if (!visited.containsKey(node.value)) {
            println(node.value)
            visited.set(node.value, 1)
            visitAdjacent(visited, node.adj)
        }
    }
}



