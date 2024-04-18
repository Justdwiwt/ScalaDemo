package leetCode._2700

object Solution_2604 {
  def minimumTime(hens: Array[Int], grains: Array[Int]): Int = {
    var left = 0
    var right = 2000000000
    val sortedH = hens.sorted
    val sortedG = grains.sorted

    def check(hens: Array[Int], grains: Array[Int], t: Int): Boolean = {
      val n = grains.length
      var j = 0
      var i = 0
      while (i < hens.length && j < n) {
        var min = hens(i)
        var max = hens(i)
        var flag = true
        while (flag && j < n) {
          min = min.min(grains(j))
          max = max.max(grains(j))
          if ((hens(i) - min - min + max).min(max - hens(i) - min + max) <= t) j += 1
          else flag = false
        }
        i += 1
      }
      j == n
    }

    while (left < right) {
      val mid = (right - left) / 2 + left
      if (check(sortedH, sortedG, mid)) right = mid
      else left = mid + 1
    }
    left
  }
}
