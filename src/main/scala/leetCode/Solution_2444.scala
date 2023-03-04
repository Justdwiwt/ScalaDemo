package leetCode

object Solution_2444 {
  def countSubarrays(nums: Array[Int], minK: Int, maxK: Int): Long = {
    var idx1 = -1
    var idx2 = -1
    var base = 0
    var res = 0L
    nums.indices.foreach(i => {
      if (nums(i) == minK) idx1 = i
      if (nums(i) == maxK) idx2 = i
      if (nums(i) < minK || nums(i) > maxK) base = i + 1
      res += 0.max(idx1.min(idx2) - base + 1)
    })
    res
  }
}
