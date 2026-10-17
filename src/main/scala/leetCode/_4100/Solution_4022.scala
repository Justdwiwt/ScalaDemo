package leetCode._4100

object Solution_4022 {
  def kthDigit(k: Long): Int = {
    @scala.annotation.tailrec
    def find(k: Long, cnt: Long, len: Int): (Long, Long, Int) =
      if (cnt * len > k) (k, cnt, len)
      else find(k - cnt * len, cnt * 10, len + 1)

    val (n, cnt, len) = find(k - 1, 9L, 1)
    val x = cnt / 9 + n / len
    val num = if (x / 10 % 2 == 1) x + 9 - x % 10 * 2 else x
    val p = math.pow(10, len - (n % len).toInt - 1).toLong

    (num / p % 10).toInt
  }
}
