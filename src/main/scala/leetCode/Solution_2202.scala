package leetCode

object Solution_2202 {
  def maximumTop(nums: Array[Int], k: Int): Int = {
    var res = 0
    val n = nums.length
    if (n == 1 && k % 2 == 1) return -1
    if (n == 1 && k % 2 == 0) return nums.head
    if (k > n) {
      nums.foreach(i => res = res.max(i))
      return res
    }
    else if (k == n) {
      (0 until k - 1).foreach(i => res = res.max(nums(i)))
      return res
    }
    else if (k < n) {
      (0 until k - 1).foreach(i => res = res.max(nums(i)))
      return res.max(nums(k))
    }
    res
  }
}
