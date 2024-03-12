package leetCode._700

object Solution_658 {
  def findClosestElements(arr: Array[Int], k: Int, x: Int): List[Int] = {
    var l = 0
    var r = arr.length - k
    while (l < r) {
      val m = (l + r) >>> 1
      if ((x - arr(m)) <= (arr(m + k) - x)) r = m
      else l = m + 1
    }
    arr.slice(l, l + k).toList
  }
}
