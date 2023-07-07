package leetCode

object Solution_2760 {
  def longestAlternatingSubarray(nums: Array[Int], threshold: Int): Int = {
    var start = 0
    var res = 0
    nums.indices.foreach(i => {
      if (nums(i) > threshold) start = i + 1
      else if (i != 0 && nums(i - 1) % 2 == nums(i) % 2) start = i
      if (start == i && nums(i) % 2 != 0) start = i + 1
      res = res.max(i - start + 1)
    })
    res
  }
}
