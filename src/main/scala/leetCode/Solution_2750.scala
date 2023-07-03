package leetCode

object Solution_2750 {
  def numberOfGoodSubarraySplits(nums: Array[Int]): Int = {
    var cnt = 1L
    val M = 1000000007
    var last = -1
    nums.indices.foreach(i => if (nums(i) == 1) {
      if (last > -1) cnt = (cnt * (i - last)) % M
      last = i
    })
    if (last == -1) 0 else cnt.toInt
  }
}
