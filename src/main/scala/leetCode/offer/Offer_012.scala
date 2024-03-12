package leetCode.offer

object Offer_012 {
  def pivotIndex(nums: Array[Int]): Int = nums
    .scanLeft(0)((sum, x) => sum + x)
    .drop(1)
    .zipWithIndex
    .indexWhere({ case (l, idx) => nums.scanRight(0)((sum, x) => sum + x).dropRight(1)(idx) == l })
}
