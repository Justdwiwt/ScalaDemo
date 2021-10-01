package leetCode

object Offer_009 {
  def numSubarrayProductLessThanK(nums: Array[Int], k: Int): Int = {
    var count = 0
    var b = 0
    var e = 0
    var prod = 1
    while (e < nums.length) {
      prod *= nums(e)
      while (b < nums.length && prod >= k) {
        prod /= nums(b)
        b += 1
      }
      count += e - b + 1
      e += 1
    }
    if (count <= 0) 0 else count
  }
}
