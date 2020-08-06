package leetCode

object Solution_1534 {
  def countGoodTriplets(arr: Array[Int], a: Int, b: Int, c: Int): Int = {
    var res = 0
    (0 until arr.length - 2).foreach(i => (i + 1 until arr.length - 1).foreach(j => (j + 1 until arr.length).foreach(k =>
      if ((arr(i) - arr(j)).abs <= a && (arr(j) - arr(k)).abs <= b && (arr(i) - arr(k)).abs <= c) res += 1
    )))
    res
  }
}
