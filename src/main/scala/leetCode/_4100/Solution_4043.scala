package leetCode._4100

object Solution_4043 {
  def countRotations(s: String, k: Int): Int = {
    val res = (s ++ s.take(1)).sliding(2).count(n => n(0) == n(1))
    if (res - 1 == k) res else if (res == k) s.length - res else 0
  }
}
