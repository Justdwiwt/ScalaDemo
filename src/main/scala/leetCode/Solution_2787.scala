package leetCode

object Solution_2787 {
  def numberOfWays(n: Int, x: Int): Int = {
    val res = Array.fill(n + 1)(0)
    res(0) = 1
    var i = 1
    val p = math.pow(i, x).toInt
    while (p <= n) {
      (n to p by -1).foreach(j => {
        res(j) += res(j - p)
        res(j) %= 1000000007
      })
      i += 1
    }
    res(n)
  }
}
