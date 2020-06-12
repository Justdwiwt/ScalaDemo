package leetCode

object Solution_1306 {
  def canReach(arr: Array[Int], start: Int): Boolean = {
    if (start >= arr.length || start < 0) return false
    if (arr(start) < 0) return false
    if (arr(start) == 0) return true
    val l = arr(start) + start
    val r = start - arr(start)
    arr(start) *= -1
    canReach(arr, l) || canReach(arr, r)
  }
}
