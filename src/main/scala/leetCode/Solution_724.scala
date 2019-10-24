package leetCode

object Solution_724 {
  def pivotIndex(nums: Array[Int]): Int = {
    val len = nums.length
    var sum = 0
    var cur = 0
    (0 until len).foreach(i => sum += nums(i))
    (0 until len).foreach(i => {
      if (i == 0) cur = 0
      else cur += nums(i - 1)
      if (cur << 1 == sum - nums(i)) return i
    })
    -1
  }
}
