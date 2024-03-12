package leetCode._700

object Solution_668 {
  def findKthNumber(m: Int, n: Int, k: Int): Int = {
    var l = 0
    var r = m * n
    while (l < r) {
      val mid = (l + r) >>> 1
      var cnt = 0
      (1 to m).foreach(i => cnt += (if (n < mid / i) n else mid / i))
      if (cnt >= k) r = mid
      else l = mid + 1
    }
    l
  }
}
