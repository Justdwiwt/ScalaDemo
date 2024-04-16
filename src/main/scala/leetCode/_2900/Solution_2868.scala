package leetCode._2900

object Solution_2868 {
  def canAliceWin(a: Array[String], b: Array[String]): Boolean = {
    @scala.annotation.tailrec
    def f(i: Int, j: Int, k: Int, cur: String): Boolean =
      if (k == 1) {
        if (j == b.length) return true
        if ((b(j).head == cur.head && b(j) > cur) || b(j).head - cur.head == 1)
          f(i, j + 1, 1 - k, b(j))
        else f(i, j + 1, k, cur)
      } else {
        if (i == a.length) return false
        if ((a(i).head == cur.head && a(i) > cur) || a(i).head - cur.head == 1)
          f(i + 1, j, 1 - k, a(i))
        else f(i + 1, j, k, cur)
      }

    f(1, 0, 1, a.head)
  }
}
