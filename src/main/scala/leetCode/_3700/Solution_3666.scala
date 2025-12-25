package leetCode._3700

object Solution_3666 {
  def minOperations(s: String, k: Int): Int = {
    val n = s.length
    val z = s.count(_ == '0')
    if (z == 0) 0
    else if (k == n) if (z == n) 1 else -1
    else {
      val inf = Int.MaxValue / 2

      def up(a: Int, b: Int) =
        (a + b - 1) / b

      val even =
        if (z % 2 == 0) {
          val m = math.max(up(z, k), up(z, n - k))
          m + m % 2
        }
        else inf
      val odd =
        if (z % 2 == k % 2) {
          val m = math.max(up(z, k), up(n - z, n - k))
          m | 1
        }
        else inf
      val ans = math.min(even, odd)
      if (ans >= inf) -1 else ans
    }
  }
}
