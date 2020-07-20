package leetCode

object Solution_1482 {
  def minDays(bloomDay: Array[Int], m: Int, k: Int): Int = {
    var l = 0
    var r = 1e9.toInt
    if (m * k > bloomDay.length) return -1
    while (l < r) {
      var bloom = 0
      var flow = 0
      val mid = l + (r - l) / 2
      bloomDay.indices.foreach(i => {
        if (bloomDay(i) > mid) flow = 0
        else flow += 1
        if (flow >= k) {
          bloom += 1
          flow = 0
        }
      })
      if (bloom < m) l = mid + 1
      else r = mid
    }
    l
  }
}
