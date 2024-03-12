package leetCode._1500

object Solution_1414 {
  def findMinFibonacciNumbers(k: Int): Int = {
    val arr = Array.fill(45)(0)
    var i = 0
    var res = 0
    var K = k
    arr(1) = 1
    i = 2
    while (i < 45) {
      arr(i) = arr(i - 1) + arr(i - 2)
      i += 1
    }
    i = 44
    while (i > 0) {
      if (K >= arr(i)) {
        K -= arr(i)
        res += 1
      }
      i -= 1
    }
    res
  }
}
