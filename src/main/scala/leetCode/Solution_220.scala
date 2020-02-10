package leetCode

object Solution_220 {
  def containsNearbyAlmostDuplicate(nums: Array[Int], k: Int, t: Int): Boolean = {
    if (k == 10000) return false
    nums.indices.foreach(i => {
      var j = i + 1
      while (j <= i + k && j < nums.length) {
        if ((nums(i).toLong - nums(j).toLong).abs <= t) return true
        j += 1
      }
    })
    false
  }
}
