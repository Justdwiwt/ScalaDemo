package leetCode._3500

object Solution_3425 {
  def longestSpecialPath(edges: Array[Array[Int]], nums: Array[Int]): Array[Int] = {
    val n = nums.length
    val graph = Array.fill(n)(List.empty[(Int, Int)])
    edges.foreach { case Array(x, y, w) =>
      graph(x) = (y, w) :: graph(x)
      graph(y) = (x, w) :: graph(y)
    }

    var res = (-1, 0)
    val dis = collection.mutable.ArrayBuffer(0)
    val lastDepth = collection.mutable.Map[Int, Int]()

    def dfs(node: Int, parent: Int, topDepth: Int): Unit = {
      val color = nums(node)
      val oldDepth = lastDepth.getOrElse(color, 0)
      val newTopDepth = topDepth.max(oldDepth)

      val currentPathLength = dis.last - dis(newTopDepth)
      val currentDepthDiff = dis.length - newTopDepth
      res = Seq(res, (currentPathLength, -currentDepthDiff)).maxBy { case (length, depth) => (length, depth) }

      lastDepth(color) = dis.length
      graph(node).foreach { case (next, weight) =>
        if (next != parent) {
          dis.append(dis.last + weight)
          dfs(next, node, newTopDepth)
          dis.remove(dis.length - 1)
        }
      }
      lastDepth(color) = oldDepth
    }

    dfs(0, -1, 0)
    Array(res._1, -res._2)
  }
}
