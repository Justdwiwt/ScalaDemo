package leetCode._3900

object Solution_3812 {
  def minimumFlips(n: Int, edges: Array[Array[Int]], start: String, target: String): List[Int] = {

    val g = Array.fill(n)(List.empty[(Int, Int)])
    edges.zipWithIndex.foreach { case (e, i) =>
      val x = e.head
      val y = e(1)
      g(x) = (y, i) :: g(x)
      g(y) = (x, i) :: g(y)
    }

    val ans = collection.mutable.ArrayBuffer.empty[Int]

    def dfs(x: Int, fa: Int): Boolean = {
      val self = start.charAt(x) != target.charAt(x)

      g(x)
        .filter(_._1 != fa)
        .foldLeft(self) {
          case (rev, (y, idx)) =>
            if (dfs(y, x)) {
              ans += idx
              !rev
            } else rev
        }
    }

    if (dfs(0, -1)) List(-1)
    else ans.toList.sorted
  }
}
