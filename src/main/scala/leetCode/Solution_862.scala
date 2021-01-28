package leetCode

object Solution_862 {
  def shortestSubarray(array: Array[Int], k: Int): Int = {
    var idx = 0
    var sum = 0
    var i = 0
    val len = array.length
    var cur = -1
    var shortestLen = len + 1
    while (i < len) {
      cur = array(i)
      if (cur >= k) return 1
      sum += cur
      i += 1
      if (sum >= k) {
        shortestLen = shortestLen.min(i - idx)
        idx += 1
        i = idx
        sum = 0
      } else if (sum <= 0) {
        idx = i
        sum = 0
      }
    }
    if (shortestLen < len + 1) shortestLen else -1
  }
}
