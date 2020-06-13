package leetCode

object Solution_1300 {
  def findBestValue(arr: Array[Int], target: Int): Int = {
    var l = 0
    var r = arr.max
    while (l < r) {
      val m = (l + r) >>> 1
      if (g(arr, m) <= target) l = m else r = m - 1
    }

    def g(arr: Array[Int], v: Int): Int = {
      var res = 0
      arr.foreach(i => if (i > v) res += v else res += i)
      res
    }

    if ((g(arr, l) - target).abs <= (g(arr, l + 1) - target).abs) l else l + 1
  }
}
