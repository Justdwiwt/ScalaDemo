package leetCode._2900

object Solution_2875 {
  def minSizeSubarray(nums: Array[Int], target: Int): Int = {
    val total = nums.sum
    val dup = nums ++ nums
    val (repeats, need) = (target / total, target % total)

    @scala.annotation.tailrec
    def slide(l: Int, r: Int, sum: Int, minLen: Int): Int =
      if (sum > need) slide(l + 1, r, sum - dup(l), minLen)
      else if (sum < need && r < dup.length) slide(l, r + 1, sum + dup(r), minLen)
      else if (sum == need)
        if (l >= dup.length) minLen.min(r - l)
        else slide(l + 1, r, sum - dup(l), minLen.min(r - l))
      else minLen

    val diff = slide(0, 0, 0, Int.MaxValue)
    if (diff == Int.MaxValue) -1
    else (repeats * nums.length) + diff
  }
}
