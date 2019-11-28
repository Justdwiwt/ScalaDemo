package leetCode

object Solution_45 {
  def jump(nums: Array[Int]): Int = {
    var res = 0
    var i = 0
    var cur = 0
    while (cur < nums.length - 1) {
      res += 1
      val pre = cur
      while (i <= pre) {
        cur = cur.max(i + nums(i))
        i += 1
      }
      if (pre == cur) return -1
    }
    res
  }
}
