package leetCode.offer

object Offer_004 {
  def singleNumber(nums: Array[Int]): Int = nums./:(0 -> 0) {
    case ((ones, twos), num) =>
      val newOnes = (ones ^ num) & (~twos)
      newOnes -> ((twos ^ num) & (~newOnes))
  }._1
}
