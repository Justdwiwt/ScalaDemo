package leetCode

object Solution_2087 {
  def minCost(startPos: Array[Int], homePos: Array[Int], rowCosts: Array[Int], colCosts: Array[Int]): Int = {
    val Array(sx, sy) = startPos
    val Array(hx, hy) = homePos
    var res = 0
    (sx + (if (hx > sx) 1 else -1) to hx by (if (hx > sx) 1 else -1)).foreach(r => res += rowCosts(r))
    (sy + (if (hy > sy) 1 else -1) to hy by (if (hy > sy) 1 else -1)).foreach(c => res += colCosts(c))
    res
  }
}
