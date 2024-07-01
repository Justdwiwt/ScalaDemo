package leetCode._3200

object Solution_3200 {
  def maxHeightOfTriangle(red: Int, blue: Int): Int = {
    def f(n: Int, m: Int): Int = {
      val odd = math.sqrt(n).toInt
      val even = ((math.sqrt(m * 4 + 1) - 1) / 2).toInt
      if (odd > even) even * 2 + 1 else odd * 2
    }

    f(red, blue).max(f(blue, red))
  }
}
