package leetCode._3300

object Solution_3240 {
  def minFlips(g: Array[Array[Int]]): Int = {
    val n = g.length
    val m = g.head.length
    var cost = 0
    g.indices.foreach(i => g.head.indices.foreach(j => if (g(i)(j) == 1) cost += 1))
    var (c1, c2) = (0, 0)
    (0 until (n + 1) / 2).foreach(i => (0 until (m + 1) / 2).foreach(j => {
      val points = Set(
        (i, j),
        (i, m - 1 - j),
        (n - 1 - i, j),
        (n - 1 - i, m - 1 - j)
      )
      val cnt = points.count { case (x, y) => g(x)(y) == 1 }
      points.size match {
        case 2 => if (cnt == 1) c1 += 1 else if (cnt == 2) c2 += 1
        case 4 => if (cnt > 2) {
          cost -= cnt
          cost += (4 - cnt)
        }
        case _ =>
      }
    }))
    if (c2 % 2 == 1) {
      if (c1 > 0) cost -= 2
      c2 -= 1
    }
    cost -= c2 * 2
    cost
  }
}
