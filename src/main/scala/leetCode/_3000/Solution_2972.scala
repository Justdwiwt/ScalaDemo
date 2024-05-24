package leetCode._3000

object Solution_2972 {
  def incremovableSubarrayCount(a: Array[Int]): Long = {
    val n = a.length
    var i = 0
    while (i < n - 1 && a(i) < a(i + 1)) i += 1
    if (i == n - 1) return (n.toLong * (n + 1)) / 2

    var res = i + 2L
    var j = n - 1
    while (j == n - 1 || a(j) < a(j + 1)) {
      var tempI = i
      while (tempI >= 0 && a(tempI) >= a(j)) tempI -= 1
      res += tempI + 2L
      j -= 1
    }
    res
  }
}
