package leetCode

object Solution_2980 {
  def hasTrailingZeros(nums: Array[Int]): Boolean = {
    var cnt = 0
    nums.indices.foreach(i => if ((nums(i) & 1) == 0) cnt += 1)
    cnt >= 2
  }
}
