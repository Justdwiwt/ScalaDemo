package leetCode._2500

object Solution_2419 {
  def longestSubarray(nums: Array[Int]): Int = {
    val mx = nums.max
    nums./:(0, 0) { case ((len, cur), n) =>
      if (n != mx) (len, 0)
      else (len.max(cur + 1), cur + 1)
    }._1
  }
}
