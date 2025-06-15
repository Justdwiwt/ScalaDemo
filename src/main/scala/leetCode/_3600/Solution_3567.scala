package leetCode._3600

object Solution_3567 {
  def minAbsDiff(grid: Array[Array[Int]], k: Int): Array[Array[Int]] = {
    val m = grid.length
    val n = grid.head.length
    val res = Array.ofDim[Int](m - k + 1, n - k + 1)

    (0 to m - k).foreach(i => (0 to n - k).foreach(j => {
      val subArray = grid.slice(i, i + k).flatMap(_.slice(j, j + k)).sorted

      val minDiff = subArray
        .sliding(2)
        .collect { case Array(x, y) if x < y => y - x }
        .foldLeft(Int.MaxValue)(Math.min)

      res(i)(j) = if (minDiff == Int.MaxValue) 0 else minDiff
    }))
    res
  }
}
