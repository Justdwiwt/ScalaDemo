package leetCode.offer

object Offer_53_2 {
  def missingNumber(nums: Array[Int]): Int = {
    var l = 0
    var r = nums.length - 1
    while (l <= r) {
      val mid = (l + r) >>> 1
      if (nums(mid) == mid) l = mid + 1
      else r = mid - 1
    }
    l
  }
}
