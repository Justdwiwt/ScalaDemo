package leetCode._2500

object Solution_2412 {
  def minimumMoney(transactions: Array[Array[Int]]): Long = transactions
    .map { case Array(cost, cashback) => (cost.toLong - cashback).max(0L) }
    .sum + transactions.map(_.min).max
}
