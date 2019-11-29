package leetCode

object Solution_312 {
  def maxCoins(nums: Array[Int]): Int = {
    val n = nums.toBuffer
    n.insert(nums.head, 1)
    n.append(1)
    val t = n.toArray
    val dp = Array.fill(nums.length + 2, nums.length + 2)(0)
    (1 to nums.length).foreach(len => (1 to (nums.length - len + 1)).foreach(i => {
      val j = i + len - 1
      (i to j).foreach(k => dp(i)(j) = dp(i)(j).max(t(i - 1) * t(k) * t(j + 1) + dp(i)(k - 1) + dp(k + 1)(j)))
    }))
    dp(1)(nums.length)
  }
}
