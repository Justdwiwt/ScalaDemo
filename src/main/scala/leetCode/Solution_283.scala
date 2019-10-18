package leetCode

object Solution_283 {
  def moveZeroes(nums: Array[Int]): Unit = {
    var po = 0
    for (i <- nums.indices)
      if (nums(i) != 0) {
        nums(po) = nums(i)
        po += 1
      }
    while (po < nums.length) {
      nums(po) = 0
      po += 1
    }
  }
}
