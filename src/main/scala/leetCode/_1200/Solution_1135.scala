package leetCode._1200

object Solution_1135 {
  def minimumCost(N: Int, connections: Array[Array[Int]]): Int = {
    val sorted = connections.sortBy(_(2))
    val parent = Array.tabulate(N + 1)(identity)
    var cost = 0
    sorted.foreach(edge => if (union(edge(0), edge(1), parent)) cost += edge(2))

    var p = -1
    var i = 1
    while (i <= N) {
      val root = findRoot(i, parent)
      if (p == -1) p = root
      else if (p != root) return -1
      i += 1
    }
    cost
  }

  private def findRoot(x: Int, parent: Array[Int]): Int = {
    var tempX = x
    while (tempX != parent(tempX)) {
      parent(tempX) = parent(parent(tempX))
      tempX = parent(tempX)
    }
    tempX
  }

  private def union(a: Int, b: Int, parent: Array[Int]): Boolean = {
    val rootA = findRoot(a, parent)
    val rootB = findRoot(b, parent)
    if (rootA == rootB) false
    else {
      parent(rootA) = rootB
      true
    }
  }
}
