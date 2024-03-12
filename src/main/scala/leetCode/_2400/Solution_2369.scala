package leetCode._2400

object Solution_2369 {
  def validPartition(nums: Array[Int]): Boolean = {
    val dp = Array.fill(nums.length + 1)(false)
    dp(0) = true
    (2 to nums.length).foreach(i => {
      dp(i) |= nums(i - 1) == nums(i - 2) && dp(i - 2)
      dp(i) |= i > 2 && nums(i - 1) == nums(i - 2) && nums(i - 2) == nums(i - 3) && dp(i - 3)
      dp(i) |= i > 2 && nums(i - 1) == nums(i - 2) + 1 && nums(i - 2) == nums(i - 3) + 1 && dp(i - 3)
    })
    dp.last
  }
}
