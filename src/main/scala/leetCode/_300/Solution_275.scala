package leetCode._300

object Solution_275 {
  def hIndex(citations: Array[Int]): Int = {
    var l = 0
    var r = citations.length
    while (l < r) {
      val mid = l + ((r - l) >> 1)
      if (citations(citations.length - mid - 1) >= mid + 1) l = mid + 1
      else r = mid
    }
    l
  }
}
