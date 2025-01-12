package leetCode._3500

object Solution_3409 {
  def longestSubsequence(nums: Array[Int]): Int = {
    if (nums.isEmpty) return 0
    val mx = nums.max
    val mn = nums.min
    val maxD = mx - mn
    val arr = Array.ofDim[Int](mx + 1, maxD + 1)
    nums.foreach(x => {
      var fx = 1
      (maxD to 0 by -1).foreach(j => {
        if (x - j >= mn) fx = fx.max(arr(x - j)(j) + 1)
        if (x + j <= mx) fx = fx.max(arr(x + j)(j) + 1)
        arr(x)(j) = fx
      })
    })
    arr.flatten.max
  }
}
