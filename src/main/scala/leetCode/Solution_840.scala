package leetCode

object Solution_840 {
  def numMagicSquaresInside(grid: Array[Array[Int]]): Int = {
    def f(acc: Int, pos: (Int, Int)): Int = {
      val p = (0 to 2).flatMap(x => (0 to 2).map(y => grid(pos._1 + x)(pos._2 + y))).toList
      val q = p.distinct.sorted
      if (q == (1 to 9).toList) {
        val d = p.head + p(4) + p(8)
        val t = p(2) + p(4) + p(6) == d &&
          p.head + p(1) + p(2) == d &&
          p(3) + p(4) + p(5) == d &&
          p(6) + p(7) + p(8) == d &&
          p.head + p(3) + p(6) == d &&
          p(1) + p(4) + p(7) == d &&
          p(2) + p(5) + p(8) == d
        if (t) acc + 1 else acc
      } else acc
    }

    if (grid.length < 3 || grid(0).length < 3) 0
    else {
      val idx = (0 until grid.length - 2).flatMap(x => List(x).zipAll(0 until grid(0).length - 2, x, x)).toList
      idx.foldLeft(0)(f)
    }
  }
}
