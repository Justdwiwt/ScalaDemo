package leetCode

object Solution_53 {
  def maxSubArray(nums: Array[Int]): Int = {
    var res = Int.MinValue
    var p = 0
    nums.foreach(i => {
      p = math.max(p + i, i)
      res = math.max(res, p)
    })
    res
  }
}
