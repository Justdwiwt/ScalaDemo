package leetCode._2500

object Solution_2466 {
  def countGoodStrings(low: Int, high: Int, zero: Int, one: Int): Int = {
    val M = 1000000007
    val arr = Array.fill(high + 1)(0)
    arr(0) = 1
    (1 to high).foreach(i => {
      if (i - zero >= 0) arr(i) = (arr(i) + arr(i - zero)) % M
      if (i - one >= 0) arr(i) = (arr(i) + arr(i - one)) % M
    })
    var res = 0
    (low to high).foreach(i => res = (res + arr(i)) % M)
    res
  }
}
