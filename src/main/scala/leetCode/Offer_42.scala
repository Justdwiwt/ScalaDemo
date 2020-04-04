package leetCode

object Offer_42 {
  def maxSubArray(nums: Array[Int]): Int = {
    nums.tail.foldLeft((nums.head, nums.head)) {
      case ((preMax, preDp), cur) => (cur + preDp).max(cur).max(preMax) -> (cur + preDp).max(cur)
    }._1
  }
}
