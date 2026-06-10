package leetCode._4000

object Solution_3909 {
  def compareBitonicSums(nums: Array[Int]): Int = {
    @scala.annotation.tailrec
    def loop(i: Int, j: Int, diff: Long): Int =
      if (i == j)
        if (diff > 0) 0
        else if (diff < 0) 1
        else -1
      else
        loop(
          if (nums(i) < nums(i + 1)) i + 1 else i,
          if (nums(j) < nums(j - 1)) j - 1 else j,
          diff +
            (if (nums(i) < nums(i + 1)) nums(i) else 0) -
            (if (nums(j) < nums(j - 1)) nums(j) else 0)
        )

    loop(0, nums.length - 1, 0L)
  }
}
