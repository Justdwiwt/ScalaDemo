package leetCode

object Solution_875 {
  def minEatingSpeed(piles: Array[Int], H: Int): Int = {
    var lo = 1
    var hi = 1000000000.min(piles.max)
    while (lo < hi) {
      val mid = (lo + hi) >>> 1
      if (!check(piles, H, mid)) lo = mid + 1
      else hi = mid
    }
    lo
  }

  def check(piles: Array[Int], H: Int, K: Int): Boolean = {
    var time = 0
    piles.foreach(i => time += (i - 1) / K + 1)
    time <= H
  }
}
