package leetCode

import scala.collection.mutable

object Solution_2830 {
  def maximizeTheProfit(n: Int, offers: List[List[Int]]): Int = {
    val m = mutable.HashMap.empty[Int, List[List[Int]]]
    offers.foreach(offer => {
      val end = offer(1)
      var t = m.getOrElse(end, Nil)
      t ::= offer
      m += end -> t
    })
    val dp = Array.fill(n + 1)(0)
    (1 to n).foreach(i => {
      dp(i) = dp(i - 1)
      m.getOrElse(i - 1, Nil).foreach(offer => {
        val start = offer.head
        val gold = offer(2)
        dp(i) = dp(i).max(dp(start) + gold)
      })
    })
    dp(n)
  }
}
