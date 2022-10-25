package leetCode

object Solution_1060 {
  def missingElement(nums: Array[Int], k: Int): Int = {
    var kk = k
    nums.indices.dropRight(1).foreach(i => {
      val t = nums(i + 1) - nums(i)
      if (kk - t + 1 <= 0) return nums(i) + kk
      else kk = kk - t + 1
    })
    nums(nums.length - 1) + kk
  }
}
