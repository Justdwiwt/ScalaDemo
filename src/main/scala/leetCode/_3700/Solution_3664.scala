package leetCode._3700

object Solution_3664 {
  def score(cards: Array[String], x: Char): Int = {
    val freq1 = Array.fill(10)(0)
    val freq2 = Array.fill(10)(0)

    val both = cards.count { s =>
      val h = s.head
      val t = s.last
      if (h == x && t == x) true
      else if (h == x) {
        freq1(t - 'a') += 1
        false
      }
      else if (t == x) {
        freq2(h - 'a') += 1
        false
      }
      else false
    }

    val (max1, total1) = (freq1.max, freq1.sum)
    val (max2, total2) = (freq2.max, freq2.sum)

    (0 to both).map(i =>
      solve(i, max1, total1) + solve(both - i, max2, total2)
    ).max
  }

  private def solve(i: Int, max: Int, total: Int): Int = {
    val m = math.max(max, i)
    math.min((total + i) / 2, total + i - m)
  }
}
