package leetCode._3500

object Solution_3486 {
  def longestSpecialPath(edges: Array[Array[Int]], nums: Array[Int]): Array[Int] = {
    val n = nums.length
    val g = Array.fill[List[(Int, Int)]](n)(Nil)
    edges
      .withFilter { case Array(_, _, _) => true; case _ => false }
      .foreach { case Array(x, y, w) =>
        g(x) = (y, w) :: g(x)
        g(y) = (x, w) :: g(y)
      }

    var res: (Int, Int) = (-1, 0)
    val dis = collection.mutable.ArrayBuffer(0)
    val lastDepth = collection.mutable.Map[Int, Int]().withDefaultValue(0)

    import Ordering.Implicits._

    def dfs(x: Int, fa: Int, topDepth: Int, last1: Int): Unit = {
      val color = nums(x)
      val last2 = lastDepth(color)
      val updatedTopDepth = topDepth.max(last1.min(last2))
      val length = dis.last - dis(updatedTopDepth)
      val nodes = dis.size - updatedTopDepth
      val candidate = (length, -nodes)
      if (candidate > res) res = candidate
      val prev = lastDepth(color)
      lastDepth(color) = dis.size
      g(x)
        .withFilter { case (y, _) => y != fa }
        .foreach { case (y, w) =>
          dis += (dis.last + w)
          dfs(y, x, updatedTopDepth, last1.max(last2))
          dis.remove(dis.size - 1)
        }
      lastDepth(color) = prev
    }

    dfs(0, -1, 0, 0)
    Array(res._1, -res._2)
  }
}
