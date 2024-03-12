package leetCode._2000

object Solution_1994 {
  def numberOfGoodSubsets(nums: Array[Int]): Int = {
    val M = 1000000007L

    val arr = Array.fill(31)(0L)

    def f(n: Int, mask: Long): Long = {
      if (n > 30) return if (mask == 0) 0L else 1L

      var res = f(n + 1, mask) % M

      if (n == 2 || n == 3 || n == 5 || n == 7 || n == 11 || n == 13 || n == 17 || n == 19 || n == 23 || n == 29) {
        res = (res + arr(n) * f(n + 1, mask | (1 << n))) % M
      } else if (n == 6) {
        if ((mask & (1 << 2)) == 0 && (mask & (1 << 3)) == 0)
          res = (res + arr(n) * f(n + 1, mask | (1 << 2) | (1 << 3))) % M
      } else if (n == 10) {
        if ((mask & (1 << 2)) == 0 && (mask & (1 << 5)) == 0)
          res = (res + arr(n) * f(n + 1, mask | (1 << 2) | (1 << 5))) % M
      } else if (n == 14) {
        if ((mask & (1 << 2)) == 0 && (mask & (1 << 7)) == 0)
          res = (res + arr(n) * f(n + 1, mask | (1 << 2) | (1 << 7))) % M
      } else if (n == 22) {
        if ((mask & (1 << 2)) == 0 && (mask & (1 << 11)) == 0)
          res = (res + arr(n) * f(n + 1, mask | (1 << 2) | (1 << 11))) % M
      } else if (n == 26) {
        if ((mask & (1 << 2)) == 0 && (mask & (1 << 13)) == 0)
          res = (res + arr(n) * f(n + 1, mask | (1 << 2) | (1 << 13))) % M
      } else if (n == 15) {
        if ((mask & (1 << 3)) == 0 && (mask & (1 << 5)) == 0)
          res = (res + arr(n) * f(n + 1, mask | (1 << 3) | (1 << 5))) % M
      } else if (n == 21) {
        if ((mask & (1 << 3)) == 0 && (mask & (1 << 7)) == 0)
          res = (res + arr(n) * f(n + 1, mask | (1 << 3) | (1 << 7))) % M
      } else if (n == 30) {
        if ((mask & (1 << 2)) == 0 && (mask & (1 << 3)) == 0 && (mask & (1 << 5)) == 0)
          res = (res + arr(n) * f(n + 1, mask | (1 << 2) | (1 << 3) | (1 << 5))) % M
      }
      res
    }

    nums.foreach(arr(_) += 1)
    var res = f(1, 0L)
    (0L until arr(1)).foreach(_ => res = res * 2 % M)
    res.toInt
  }
}
