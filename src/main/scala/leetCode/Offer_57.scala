package leetCode

object Offer_57 {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    var p = 0
    var q = nums.length - 1
    while (p < q) {
      if (nums(p) + nums(q) < target) p += 1
      else if (nums(p) + nums(q) > target) q -= 1
      else return Array(nums(p), nums(q))
    }
    Array(0)
  }
}
