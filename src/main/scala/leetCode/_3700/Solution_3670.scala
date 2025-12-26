package leetCode._3700

object Solution_3670 {
  def maxProduct(nums: Array[Int]): Long = {
    val mx = nums.max
    val w = if (mx == 0) 0 else 32 - Integer.numberOfLeadingZeros(mx)
    val u = 1 << w
    val f = Array.fill(u)(0)

    nums.foreach(x => f(x) = x)

    var i = 0
    while (i < w) {
      val bit = 1 << i
      var s = 0
      while (s < u) {
        if ((s & bit) != 0) {
          val t = s ^ bit
          if (f(t) > f(s)) f(s) = f(t)
        }
        s += 1
      }
      i += 1
    }

    nums.foldLeft(0L)((ans, x) => ans.max(x.toLong * f((u - 1) ^ x)))
  }
}
