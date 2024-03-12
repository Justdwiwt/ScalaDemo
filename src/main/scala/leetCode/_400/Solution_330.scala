package leetCode._400

object Solution_330 {
  def minPatches(nums: Array[Int], n: Int): Int = {
    var i = 0
    var res = 0
    var miss: Long = 1
    while (miss <= n) {
      if (i < nums.length && nums(i) <= miss) {
        miss += nums(i)
        i += 1
      } else {
        miss += miss
        res += 1
      }
    }
    res
  }
}
