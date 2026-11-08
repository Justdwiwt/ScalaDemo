package leetCode._4100

object Solution_4039 {
  def sumDecoded(nums: Array[Long]): Int = {
    val mod = 1000000007L

    def pow(base: Long, exp: Long): Long =
      if (exp == 0) 1L
      else {
        val half = pow(base, exp / 2)
        val square = half * half % mod
        if (exp % 2 == 0) square
        else square * base % mod
      }

    nums.foldLeft(0L) { (ans, x) =>
      val d = x / 10
      val length = d.toString.length
      val pow10 = (0 until (length - (x % 10).toInt))
        .foldLeft(1L)((p, _) => p * 10)

      (ans + pow(d / pow10, d % pow10)) % mod
    }.toInt
  }
}
