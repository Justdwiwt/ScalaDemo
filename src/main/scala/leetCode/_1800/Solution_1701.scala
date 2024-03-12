package leetCode._1800

object Solution_1701 {
  def averageWaitingTime(customers: Array[Array[Int]]): Double =
    (BigDecimal(customers./:((0, BigInt(0)))((t, c) =>
      if (t._1 >= c.head) {
        val _p1 = t._1 + c(1)
        val _p2 = t._2 + (_p1 - c.head)
        (_p1, _p2)
      } else (c.head + c(1), t._2 + c(1))
    )._2) / customers.length).toDouble
}
