package leetCode._200

import scala.collection.mutable

object Solution_133 {

  class Node(var _value: Int) {
    var value: Int = _value
    var neighbors: List[Node] = List()
  }

  var visited = mutable.HashMap.empty[Node, Node]

  def cloneGraph(graph: Node): Node = {
    visited = mutable.HashMap.empty[Node, Node]
    f(graph)
  }

  def f(graph: Node): Node =
    if (graph == null) graph
    else {
      visited.getOrElse(graph, {
        val newNode = new Node(graph.value)
        visited += (graph -> newNode)
        val newNei = graph.neighbors.map(f)
        newNode.neighbors = newNei
        newNode
      })
    }
}
