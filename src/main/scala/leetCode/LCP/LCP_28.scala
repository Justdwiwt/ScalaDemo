package leetCode.LCP

object LCP_28 {
  def purchasePlans(nums: Array[Int], target: Int): Int = {
    var l, r = 0
    var n = 0L
    val sorted = nums.sorted
    r = nums.length - 1
    while (l < r) {
      if (sorted(l) + sorted(r) > target) r -= 1
      else {
        n += r - l
        l += 1
      }
    }
    (n % 1000000007).toInt
  }
}
