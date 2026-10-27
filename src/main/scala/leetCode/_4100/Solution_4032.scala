package leetCode._4100

object Solution_4032 {
  def longestSubarray(nums: Array[Int], k: Int): Int = {
    val mx = nums.max
    val spf = Array.tabulate(mx + 1)(identity)

    (2 to math.sqrt(mx).toInt).foreach { i =>
      if (spf(i) == i)
        (i * i to mx by i).foreach(j => if (spf(j) == j) spf(j) = i)
    }

    def factors(x: Int): List[Int] =
      if (x <= 1) Nil
      else {
        val p = spf(x)
        p :: factors({
          var y = x
          while (y % p == 0) y /= p
          y
        })
      }

    val cnt = collection.mutable.Map[Int, Int]()
    var left = 0
    var ans = 0

    nums.indices.foreach { right =>
      factors(nums(right)).foreach(p => cnt(p) = cnt.getOrElse(p, 0) + 1)

      while (cnt.size > k) {
        factors(nums(left)).foreach { p =>
          if (cnt(p) == 1) cnt -= p
          else cnt(p) -= 1
        }
        left += 1
      }

      ans = ans.max(right - left + 1)
    }

    ans
  }
}
