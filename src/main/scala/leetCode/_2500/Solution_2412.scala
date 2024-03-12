package leetCode._2500

object Solution_2412 {
  def minimumMoney(transactions: Array[Array[Int]]): Long = {
    var neg = 0L
    var res = 0L
    transactions.foreach(tran => neg += 0L.max(tran.head - tran(1)))
    transactions.foreach(tran => res = res.max(neg + tran.head.min(tran(1))))
    res
  }
}
