package leetCode

object Offer_070 {
  def singleNonDuplicate(nums: Array[Int]): Int =
    nums.reduce(_ ^ _)
}
