package leetCode._4100

object Solution_4051 {
  def distantSubarrays(nums: Array[Int], goal: Int, k: Int): Long = {
    val s = nums.scanLeft(0L)(_ + _)
    val sorted = s.distinct.sorted
    val m = sorted.length
    val tree = Array.fill(m + 1)(0L)

    def lowerBound(x: Long): Int = {
      var l = 0
      var r = m
      while (l < r) {
        val mid = l + (r - l) / 2
        if (sorted(mid) < x) l = mid + 1
        else r = mid
      }
      l
    }

    def upperBound(x: Long): Int = {
      var l = 0
      var r = m
      while (l < r) {
        val mid = l + (r - l) / 2
        if (sorted(mid) <= x) l = mid + 1
        else r = mid
      }
      l
    }

    def update(i: Int): Unit = {
      var x = i
      while (x <= m) {
        tree(x) += 1
        x += x & -x
      }
    }

    def prefix(i: Int): Long = {
      var x = i
      var res = 0L
      while (x > 0) {
        res += tree(x)
        x -= x & -x
      }
      res
    }

    def query(l: Int, r: Int): Long =
      if (l > r) 0L
      else prefix(r) - prefix(l - 1)

    var ans = nums.length.toLong * (nums.length + 1) / 2

    s.foreach { v =>
      val l = upperBound(v - goal - k) + 1
      val r = lowerBound(v - goal + k)

      ans -= query(l, r)

      update(lowerBound(v) + 1)
    }

    ans
  }
}
