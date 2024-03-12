package leetCode._1600

object Solution_1553 {
  def minDays(n: Int): Int = {
    val m = Map.empty[Int, Int]
    if (n == 0 || n == 1) return n
    if (m.contains(n)) return m(n)
    (minDays(n / 2) + n % 2 + 1).min(minDays(n / 3) + n % 3 + 1)
  }
}
