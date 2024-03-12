package leetCode._1800

object Solution_1749 {
  def maxAbsoluteSum(nums: Array[Int]): Int = {
    var (_, sum, mx) = (0, 0, 0)
    nums.indices.foreach(i => {
      sum += nums(i)
      mx = mx.max(sum)
      if (sum < 0) sum = 0
    })
    sum = 0
    nums.indices.foreach(i => {
      sum += -nums(i)
      mx = mx.max(sum)
      if (sum < 0) sum = 0
    })
    mx
  }
}
