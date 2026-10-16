package leetCode._4100

object Solution_4021 {
  def minOperations(s: String): Int = {
    val n = s.length
    val a = s.map(_ - 'a').toArray

    s.indices.map(rot => rot + (0 until n / 2).map(i => {
      val x = a((rot + i) % n)
      val y = a((rot + n - 1 - i) % n)
      ((x - y + 26) % 26).min((y - x + 26) % 26)
    }).sum).min
  }
}
