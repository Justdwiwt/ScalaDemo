package leetCode

object Solution_493 {
  def reversePairs(nums: Array[Int]): Int = {
    merge(nums, 0, nums.length - 1)
  }

  def merge(nums: Array[Int], left: Int, right: Int): Int = {
    if (left >= right) return 0
    var cnt = 0
    val m = left + (right - left) / 2
    cnt += merge(nums, left, m)
    cnt += merge(nums, m + 1, right)
    var j = m + 1
    (left to m).foreach(i => {
      while (j <= right && nums(i) / 2.0 > nums(j)) j += 1
      cnt += j - m - 1
    })
    java.util.Arrays.sort(nums, left, right + 1)
    cnt
  }
}
