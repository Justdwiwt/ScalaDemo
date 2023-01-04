package leetCode

object Solution_2522 {
  def minimumPartition(s: String, k: Int): Int = s
    .map(_ - '0')
    ./:(1, 0L) { case ((cnt, curr), digit) =>
      if (digit > k) return -1
      val next = curr * 10 + digit
      if (next > k) (cnt + 1, digit) else (cnt, next)
    }
    ._1
}
