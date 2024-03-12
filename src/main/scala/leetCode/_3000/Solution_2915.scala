package leetCode._3000

object Solution_2915 {
  def lengthOfLongestSubsequence(nums: List[Int], target: Int): Int = {
    val arr = Array.fill(target + 1)(Int.MinValue)
    arr(0) = 0
    var s = 0
    nums.foreach(x => {
      s = target.min(s + x)
      (s to x by -1).foreach(j => arr(j) = arr(j).max(arr(j - x) + 1))
    })
    if (arr(target) > 0) arr(target) else -1
  }
}
