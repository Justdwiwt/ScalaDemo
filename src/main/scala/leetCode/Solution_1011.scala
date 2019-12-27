package leetCode

object Solution_1011 {
  def shipWithinDays(weights: Array[Int], D: Int): Int = {
    var l = 0
    var h = Int.MaxValue
    while (l < h) {
      val mid = l + (h - l) / 2
      if (func(weights, D, mid)) h = mid else l = mid + 1
    }
    l
  }

  def func(weights: Array[Int], D: Int, K: Int): Boolean = {
    var cur = K
    var d = D
    weights.foreach(i => {
      if (i > K) return false
      if (cur < i) {
        cur = K
        d -= 1
      }
      cur -= i
    })
    d > 0
  }
}
