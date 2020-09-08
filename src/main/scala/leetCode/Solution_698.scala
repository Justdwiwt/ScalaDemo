package leetCode

object Solution_698 {
  def canPartitionKSubsets(nums: Array[Int], k: Int): Boolean = {
    val sum = nums.sum
    val mx = nums.max
    if (sum % k != 0 || mx > sum / k) false
    else f(nums, k, Array.fill(nums.length)(false), sum / k, 0, 0)
  }

  def f(nums: Array[Int], k: Int, vis: Array[Boolean], target: Int, cur: Int, idx: Int): Boolean = {
    if (k == 0) return true
    if (cur == target) return f(nums, k - 1, vis, target, 0, 0)
    (idx until nums.length).foreach(i => if (!vis(i) && cur + nums(i) <= target) {
      vis(i) = true
      if (f(nums, k, vis, target, cur + nums(i), i + 1)) return true
      vis(i) = false
    })
    false
  }
}
