package leetCode._800

object Solution_713 {
  def numSubarrayProductLessThanK(nums: Array[Int], k: Int): Int = {
    var start = 0
    var res = 0
    var product = 1
    nums.indices.foreach(end => {
      product *= nums(end)
      while (product >= k && start < end) {
        product /= nums(start)
        start += 1
      }
      if (product < k) res += (end - start) + 1
    })
    res
  }
}
