package leetCode._1400

object Solution_1359 {
  def countOrders(n: Int): Int = {
    var res = BigDecimal(1)
    val M = BigDecimal(1e9 + 7)
    (2 to n).foreach(i => res = res * (2 * i - 1) * i % M)
    res.toInt
  }
}
