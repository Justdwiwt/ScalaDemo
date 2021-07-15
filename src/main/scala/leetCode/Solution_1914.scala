package leetCode

object Solution_1914 {
  def rotateGrid(grid: Array[Array[Int]], k: Int): Array[Array[Int]] = {
    val m = grid.length
    val n = grid.head.length
    val l = m.min(n) / 2

    def circleLength(ci: Int = 0): Int = 2 * (m - 2 * ci) + 2 * (n - 2 * ci) - 4

    def get(ci: Int = 0, i: Int): Int = {
      val cm = m - 2 * ci
      val cn = n - 2 * ci
      if (i < cn) grid(ci)(ci + i)
      else if (i < cn + cm - 1) grid(ci + i - cn + 1)(n - ci - 1)
      else if (i < 2 * cn + cm - 2) grid(m - ci - 1)(ci + 2 * cn + cm - 2 - i - 1)
      else grid(ci + circleLength(ci) - i)(ci)
    }

    def set(ci: Int = 0, i: Int, v: Int): Unit = {
      val cm = m - 2 * ci
      val cn = n - 2 * ci
      if (i < cn) grid(ci)(ci + i) = v
      else if (i < cn + cm - 1) grid(ci + i - cn + 1)(n - ci - 1) = v
      else if (i < 2 * cn + cm - 2) grid(m - ci - 1)(ci + 2 * cn + cm - 2 - i - 1) = v
      else grid(ci + circleLength(ci) - i)(ci) = v
    }

    (0 until l)
      .map({ ci => val cl = circleLength(ci); (ci, cl) })
      .map({ case (ci, cl) => val offset = k % cl; (ci, cl, offset) })
      .withFilter({ case (_, _, offset) => offset != 0 })
      .foreach({ case (ci, cl, offset) =>
        val tmp = Array.fill[Int](offset)(0)
        (0 until offset).foreach(i => tmp(i) = get(ci, i))
        (0 until cl)
          .map({ i => val fr = (i + offset) % cl; (i, fr) })
          .foreach({ case (i, fr) => if (fr < offset) set(ci, i, tmp(fr)) else set(ci, i, get(ci, fr)) })
      })
    grid
  }
}
