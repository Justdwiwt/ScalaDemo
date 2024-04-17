package leetCode._3100

object Solution_3004 {
  def maximumSubtreeSize(edges: Array[Array[Int]], colors: Array[Int]): Int = {
    val n = colors.length
    val g = Array.fill(n)(List.empty[Int])
    edges.foreach { case Array(i, j) =>
      g(i) ::= j
      g(j) ::= i
    }

    def f(root: Int, fa: Int): (Int, Int) = {
      val (res, m, color) = g(root).foldLeft((0, 0, colors(root))) { case ((accRes, accM, accColor), i) =>
        if (i != fa) {
          val (x, y) = f(i, root)
          val newColor = if (x == accColor) accColor else -1
          (accRes + y, accM.max(y), newColor)
        } else (accRes, accM, accColor)
      }
      if (color != -1) (color, res + 1) else (color, m)
    }

    f(0, 0)._2
  }
}
