package leetCode._4000

object Solution_3934 {
  def smallestUniqueSubarray(nums: Array[Int]): Int = {
    val n = nums.length
    val base = 100003L
    val mod = 1000000007L

    val pow = Array.fill[Long](n + 1)(1L)
    val pre = Array.fill[Long](n + 1)(0L)

    (1 to n).foreach(i => pow(i) = pow(i - 1) * base % mod)

    nums.indices.foreach(i => pre(i + 1) = (pre(i) * base + nums(i) + 1) % mod)

    def hash(l: Int, r: Int): Long =
      ((pre(r) - pre(l) * pow(r - l)) % mod + mod) % mod

    def check(len: Int): Boolean = {
      val cnt = collection.mutable.HashMap.empty[Long, Int]

      (0 to n - len).foreach(i => {
        val h = hash(i, i + len)
        cnt.update(h, cnt.getOrElse(h, 0) + 1)
      })

      cnt.values.exists(_ == 1)
    }

    var l = 1
    var r = n
    var ans = n

    while (l <= r) {
      val m = (l + r) >>> 1

      if (check(m)) {
        ans = m
        r = m - 1
      } else l = m + 1
    }

    ans
  }
}
