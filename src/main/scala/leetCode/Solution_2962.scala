package leetCode

object Solution_2962 {
  def countSubarrays(nums: Array[Int], k: Int): Long = {
    val n = nums.length
    val mx = nums.max
    var cnt = 0
    var res = 0L
    var j = 0
    nums.indices.foreach(i => {
      while (j < nums.length && cnt < k) {
        if (nums(j) == mx) cnt += 1
        j += 1
      }
      if (cnt >= k) res += n - j + 1
      if (nums(i) == mx) cnt -= 1
    })
    res
  }
}
