package leetCode

object Solution_741 {
  def cherryPickup(grid: Array[Array[Int]]): Int = {
    val dp = Array.ofDim[Int](grid.length, grid.length, grid.length)
    grid.indices.foreach(x1 => grid.indices.foreach(y1 => grid.indices.foreach(x2 => {
      val y2 = x1 + y1 - x2
      if (y2 < 0 || y2 >= grid.length || grid(x1)(y1) == -1 || grid(x2)(y2) == -1)
        dp(x1)(y1)(x2) = Int.MinValue
      else if (x1 == 0 && y1 == 0 && x2 == 0)
        dp(x1)(y1)(x2) = grid(0)(0)
      else {
        val m = g(dp, x1 - 1, y1, x2 - 1)
          .max(g(dp, x1 - 1, y1, x2))
          .max(g(dp, x1, y1 - 1, x2 - 1))
          .max(g(dp, x1, y1 - 1, x2))
        if (m < 0) dp(x1)(y1)(x2) = m
        else {
          val v = if (x1 == x2) grid(x1)(y1)
          else grid(x1)(y1) + grid(x2)(y2)
          dp(x1)(y1)(x2) = m + v
        }
      }
    })))
    dp(grid.length - 1)(grid.length - 1)(grid.length - 1).max(0)
  }

  def g(dp: Array[Array[Array[Int]]], x1: Int, y1: Int, x2: Int): Int = {
    if (x1 < 0 || y1 < 0 || x2 < 0) return Int.MinValue
    dp(x1)(y1)(x2)
  }
}
