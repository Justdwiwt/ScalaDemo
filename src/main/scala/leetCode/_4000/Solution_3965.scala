package leetCode._4000

object Solution_3965 {
  def finishTime(n: Int, edges: Array[Array[Int]], baseTime: Array[Int]): Long = {
    val g = Array.fill(n)(List.empty[Int])

    edges.foreach { case Array(x, y) => g(x) = y :: g(x) }

    def dfs(x: Int): Long = g(x) match {
      case Nil => baseTime(x).toLong
      case children =>
        val times = children.map(dfs)
        times.max * 2 - times.min + baseTime(x)
    }

    dfs(0)
  }
}
