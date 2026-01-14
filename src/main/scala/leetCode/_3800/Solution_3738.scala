package leetCode._3800

object Solution_3738 {
  def longestSubarray(nums: Array[Int]): Int =
    if (nums.isEmpty) 0
    else {
      val (_, _, _, ans) = nums.indices.tail.foldLeft((0, 1, 1, 1)) {
        case ((pre0, f0, f1, best), i) =>
          val tmp = f0

          val (nf0, nf1a) =
            if (nums(i - 1) <= nums(i)) (f0 + 1, f1 + 1)
            else (1, 0)

          val nf1 =
            if (i >= 2 && nums(i - 2) <= nums(i))
              nf1a.max(pre0 + 2)
            else
              nf1a.max(2)

          (tmp, nf0, nf1, best.max(tmp + 1).max(nf1))
      }

      ans
    }
}
