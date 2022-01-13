package leetCode

object Solution_2134 {
  def minSwaps(nums: Array[Int]): Int = {
    val target = nums.count(_ == 1)
    var cur = 0
    var mx = 0
    (0 until nums.length + target).foreach(i => {
      cur += nums(i % nums.length)
      if (i >= target) cur -= nums(i - target)
      mx = mx.max(cur)
    })
    target - mx
  }
}
