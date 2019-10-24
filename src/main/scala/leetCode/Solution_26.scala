package leetCode

object Solution_26 {
  def removeDuplicates(nums: Array[Int]): Int = {
    var ans = 0
    if (nums.length < 2) return nums.length
    (1 until nums.length).foreach(i =>
      if (nums(ans) != nums(i)) {
        ans = ans + 1
        nums(ans) = nums(i)
      })
    ans += 1
    ans
  }
}
