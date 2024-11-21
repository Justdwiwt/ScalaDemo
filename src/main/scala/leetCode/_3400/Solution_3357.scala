package leetCode._3400

object Solution_3357 {
  def minDifference(nums: Array[Int]): Int = {
    val n = nums.length
    val (minL, maxR) = nums
      .zipWithIndex
      .filter { case (v, i) => v != -1 && ((i > 0 && nums(i - 1) == -1) || (i < n - 1 && nums(i + 1) == -1)) }
      .foldLeft((Int.MaxValue, 0)) { case ((minL, maxR), (v, _)) => (minL.min(v), maxR.max(v)) }

    @scala.annotation.tailrec
    def f(idx: Int, preIdx: Int, res: Int): Int =
      if (idx >= n) res
      else {
        val newAns = if (nums(idx) == -1) res
        else {
          val v = nums(idx)
          if (preIdx >= 0) {
            val preV = nums(preIdx)
            if (idx - preIdx == 1) res.max((v - preV).abs)
            else {
              val (l, r) = (preV.min(v), preV.max(v))
              val d = ((r - minL).min(maxR - l) + 1) / 2
              val adjustedD = if (idx - preIdx > 2) d.min((maxR - minL + 2) / 3) else d
              res.max(adjustedD)
            }
          } else res
        }
        f(idx + 1, if (nums(idx) == -1) preIdx else idx, newAns)
      }

    f(0, -1, 0)
  }
}
