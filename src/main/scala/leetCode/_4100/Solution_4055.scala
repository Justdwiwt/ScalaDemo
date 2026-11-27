package leetCode._4100

import scala.collection.mutable

object Solution_4055 {
  def shadowPairs(nums: Array[Int]): Int = {
    val sorted = nums.distinct.sorted
    val n = nums.length
    val b = new Array[Int](n)
    val c = new Array[Int](n)
    var ans = 0

    def solve(l: Int, r: Int, lo: Int, hi: Int): Unit = {
      if (hi - lo <= 0 || r - l <= 1) return

      val mid = (lo + hi) / 2
      val low = mutable.ArrayBuffer.empty[Int]
      val high = mutable.ArrayBuffer.empty[Int]
      val seg = mutable.ArrayBuffer.empty[Int]
      var bi = 0
      var ci = 0

      (l until r).foreach { i =>
        val x = nums(i)

        if (x <= sorted(mid)) {
          while (low.nonEmpty && nums(low.last) < x)
            low.remove(low.length - 1)

          while (seg.nonEmpty && seg.last >= low.length)
            seg.remove(seg.length - 1)

          if (seg.isEmpty || (high.nonEmpty && high.last > low.last))
            seg += low.length

          low += i
          b(bi) = x
          bi += 1
        } else {
          while (high.nonEmpty && nums(high.last) >= x)
            high.remove(high.length - 1)

          val p = high.lastOption.getOrElse(-1)

          while (seg.length > 1 && low(seg(seg.length - 2)) > p)
            seg.remove(seg.length - 1)

          if (seg.nonEmpty && (high.isEmpty || high.last < low.last))
            ans += low.length - seg.last

          high += i
          c(ci) = x
          ci += 1
        }
      }

      Array.copy(b, 0, nums, l, bi)
      Array.copy(c, 0, nums, l + bi, ci)

      solve(l, l + bi, lo, mid)
      solve(l + bi, r, mid + 1, hi)
    }

    solve(0, n, 0, sorted.length - 1)
    ans
  }
}
