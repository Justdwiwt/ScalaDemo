package leetCode._3800

object Solution_3729 {
  def numGoodSubarrays(nums: Array[Int], k: Int): Long = nums
    .indices
    .foldLeft((Map(0 -> 1L), 0L, 0, 0L)) {
      case ((cnt, pre, last, ans), i) =>

        val (cnt2, last2) =
          if (i > 0 && nums(i) != nums(i - 1))
            ((0 until i - last).foldLeft((cnt, pre)) {
              case ((m, s), _) =>
                val r = (((s % k) + k) % k).toInt
                (m.updated(r, m.getOrElse(r, 0L) + 1), s - nums(i - 1))
            }._1, i)
          else (cnt, last)

        val pre2 = pre + nums(i)
        val r2 = (((pre2 % k) + k) % k).toInt

        (cnt2, pre2, last2, ans + cnt2.getOrElse(r2, 0L))
    }
    ._4
}
