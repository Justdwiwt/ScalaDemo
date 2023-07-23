package leetCode

object Solution_2789 {
  def maxArrayValue(nums: Array[Int]): Long = {
    var cur = nums(nums.length - 1).toLong
    (nums.length - 2 to 0 by -1).foreach(i => {
      if (nums(i) <= cur) cur += nums(i)
      else cur = nums(i)
    })
    cur
  }
}
