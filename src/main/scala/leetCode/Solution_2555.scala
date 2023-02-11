package leetCode

object Solution_2555 {
  def maximizeWin(prizePositions: Array[Int], k: Int): Int = {
    var l = 0
    var r = 0
    var res = 0
    val arr = Array.fill(prizePositions.length + 1)(0)
    while (r < prizePositions.length) {
      while (prizePositions(r) - prizePositions(l) > k) l += 1
      res = res.max(r - l + 1 + arr(l))
      arr(r + 1) = arr(r).max(r - l + 1)
      r += 1
    }
    res
  }
}
