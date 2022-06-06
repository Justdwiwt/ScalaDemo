package leetCode

object Solution_2294 {
  def partitionArray(nums: Array[Int], k: Int): Int = {
    val sorted = nums.sorted
    var l = 0
    var r = 0
    var res = 1
    while (r < nums.length) {
      if (sorted(r) - sorted(l) > k) {
        l = r
        res += 1
      }
      r += 1
    }
    res
  }
}
