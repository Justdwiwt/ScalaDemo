package leetCode._2400

// fixme: case 43/44 stack overflow
object Solution_2378 {
  class Edge(val to: Int, val weight: Int)

  var adj: Array[List[Edge]] = _

  def maxScore(edges: Array[Array[Int]]): Long = {
    adj = Array.fill(edges.length)(List.empty[Edge])

    edges.indices.drop(1).foreach(i => {
      val from = edges(i).head
      val weight = edges(i)(1)
      adj(from) ::= new Edge(i, weight)
    })

    dfs(0).head
  }

  private def dfs(from: Int): Array[Long] = {
    if (adj(from).isEmpty) return Array(0L, 0L)

    var sum = 0L
    var diff = 0L

    adj(from).foreach(edge => {
      val child = dfs(edge.to)
      sum += child.head
      diff = diff.max(edge.weight - child.head + child(1))
    })

    Array(sum.max(sum + diff), sum)
  }
}
