package leetCode

object Solution_875 {
  def f(piles: Array[Int], mid: Int, hours: Int): Boolean = piles./:(0) { case (acc, e) =>
    val quotient = e / mid
    val remainder = e % mid
    acc + (quotient + (if (remainder > 0) 1 else 0))
  } <= hours

  @scala.annotation.tailrec
  def binSearchPiles(piles: Array[Int], left: Int, right: Int, hours: Int): Int =
    if (left < right) {
      val m = (left + right) >>> 1
      if (f(piles, m, hours)) binSearchPiles(piles, left, m, hours)
      else binSearchPiles(piles, m + 1, right, hours)
    } else left

  def minEatingSpeed(piles: Array[Int], H: Int): Int =
    binSearchPiles(piles, 1, piles.max, H)
}
