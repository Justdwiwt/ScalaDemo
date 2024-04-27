package leetCode._1900

object Solution_1891 {
  def maxLength(ribbons: Array[Int], k: Int): Int = {
    @scala.annotation.tailrec
    def binarySearch(low: Int, high: Int): Int =
      if (low >= high) low
      else {
        val mid = (low + high + 1) >> 1
        val cnt = ribbons.map(_ / mid).sum
        if (cnt < k) binarySearch(low, mid - 1)
        else binarySearch(mid, high)
      }

    binarySearch(0, 100000)
  }
}
