package leetCode._500

object Solution_473 {
  def makesquare(nums: Array[Int]): Boolean = {
    val sum = nums.sum
    if (sum % 4 != 0) return false
    f(nums.toList, Nil, 1, sum / 4, sum / 4)
  }

  def f(nums: List[Int], next: List[Int], k: Int, s: Int, sum: Int): Boolean = {
    if (nums.isEmpty) return false
    if (k == 4) return nums.sum == sum
    if (nums.head < s) {
      if (f(nums.tail, next, k, s - nums.head, sum)) return true
    } else if (nums.head == s) {
      if (f(next ++ nums.tail, Nil, k + 1, sum, sum)) return true
    }
    f(nums.tail, nums.head :: next, k, s, sum)
  }
}
