package leetCode._3700

object Solution_3681 {
  def maxXorSubsequences(nums: Array[Int]): Int = {
    val mx = nums.max
    val m = if (mx == 0) 1 else 32 - Integer.numberOfLeadingZeros(mx)

    val basis = Array.fill(m)(0)

    def insert(x: Int): Unit = {
      @scala.annotation.tailrec
      def loop(v: Int, i: Int): Unit =
        if (v != 0 && i >= 0)
          if (((v >> i) & 1) == 0) loop(v, i - 1)
          else if (basis(i) == 0) basis(i) = v
          else loop(v ^ basis(i), i - 1)

      loop(x, m - 1)
    }

    nums.foreach(insert)

    (m - 1 to 0 by -1).foldLeft(0)((res, i) => {
      val t = res ^ basis(i)
      if (t > res) t else res
    })
  }
}
