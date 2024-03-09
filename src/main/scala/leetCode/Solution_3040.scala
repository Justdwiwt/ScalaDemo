package leetCode

object Solution_3040 {
  private var dp = Array.empty[Array[Int]]

  def maxOperations(nums: Array[Int]): Int = {
    val n = nums.length
    dp = Array.fill(n, n)(0)
    val v1 = nums.head + nums(1)
    val v2 = nums.head + nums(n - 1)
    val v3 = nums(n - 2) + nums(n - 1)
    val a = dfs(nums, v1, 2, n - 1)
    val b = dfs(nums, v2, 1, n - 2)
    val c = dfs(nums, v3, 0, n - 3)
    a.max(b.max(c)) + 1
  }

  private def dfs(nums: Array[Int], v: Int, l: Int, r: Int): Int = {
    if (r - l + 1 < 2) return 0
    if (dp(l)(r) > 0) return dp(l)(r)
    val n1 = if (nums(l) + nums(l + 1) == v) dfs(nums, v, l + 2, r) + 1 else 0
    val n2 = if (nums(l) + nums(r) == v) dfs(nums, v, l + 1, r - 1) + 1 else 0
    val n3 = if (nums(r - 1) + nums(r) == v) dfs(nums, v, l, r - 2) + 1 else 0
    dp(l)(r) = n1.max(n2.max(n3))
    dp(l)(r)
  }
}
