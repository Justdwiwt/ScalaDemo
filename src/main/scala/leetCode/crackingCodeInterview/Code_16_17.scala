package leetCode.crackingCodeInterview

object Code_16_17 {
  def maxSubArray(nums: Array[Int]): Int = {
    var res = Int.MinValue
    var sum = 0
    nums.foreach(i => {
      sum += i
      res = res.max(sum)
      if (sum < 0) sum = 0
    })
    res
  }
}
