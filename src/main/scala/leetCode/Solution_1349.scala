package leetCode

object Solution_1349 {
  def maxStudents(seats: Array[Array[Char]]): Int = {
    val valid = Array.fill(seats.length)(0)
    seats.indices.foreach(i => valid(i) = cnt(0, seats(i), seats.head.length - 1))
    val dp = Array.fill[Int](seats.length + 1, 1 << seats.head.length)(-1)
    dp(0)(0) = 0
    (1 to seats.length).foreach(i => {
      val v = valid(i - 1)
      (0 until 1 << seats.head.length).foreach(s =>
        if ((s & (s >> 1)) == 0 && (s & v) == s)
          (0 until 1 << seats.head.length).foreach(pre =>
            if ((s & (pre >> 1)) == 0 && (s & (pre << 1)) == 0 && (dp(i - 1)(pre) != -1))
              dp(i)(s) = dp(i)(s).max(dp(i - 1)(pre) + bitCount(s))))
    })
    dp(seats.length).max
  }

  def bitCount(n: Int): Int =
    if (n == 0) 0 else 1 + bitCount(n & (n - 1))

  def cnt(cur: Int, arr: Array[Char], len: Int): Int =
    if (cur > len) 0
    else ((if (arr(cur) == '.') 1 else 0) << (len - cur)) + cnt(cur + 1, arr, len)
}
