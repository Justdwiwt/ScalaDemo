package leetCode

object Solution_2616 {
  def minimizeMax(nums: Array[Int], p: Int): Int = {
    val sorted = nums.sorted
    var l = 0
    var r = sorted.max
    while (l <= r) {
      val m = (l + r) >>> 1
      val t = f(sorted, m)
      if (t >= p) r = m - 1
      else l = m + 1
    }
    l
  }

  private def f(nums: Array[Int], limit: Int): Int = {
    var p = 0
    var last: Integer = nums.head
    nums.indices.drop(1).foreach(i => {
      val n = nums(i)
      if (last != null && n - last <= limit) {
        p += 1
        last = null
      } else last = n
    })
    p
  }
}
