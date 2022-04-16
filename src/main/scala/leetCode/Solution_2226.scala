package leetCode

object Solution_2226 {
  def maximumCandies(candies: Array[Int], k: Long): Int = {
    var l = 0L
    var r = 10000000L
    while (l < r) {
      val mid = (l + r + 1) / 2
      var cnt = 0L
      candies.foreach(x => cnt += (x / mid))
      if (cnt < k) r = mid - 1
      else l = mid
    }
    l.toInt
  }
}
