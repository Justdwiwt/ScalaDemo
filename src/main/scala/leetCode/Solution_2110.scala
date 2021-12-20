package leetCode

object Solution_2110 {
  def getDescentPeriods(prices: Array[Int]): Long = {
    var start = 0
    var res = 0L
    prices.indices.drop(1).foreach(i => {
      res += i - start
      if (prices(i) != prices(i - 1) - 1) start = i
    })
    res + prices.length - start
  }
}
