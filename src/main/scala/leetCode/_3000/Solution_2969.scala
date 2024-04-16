package leetCode._3000

import scala.collection.mutable

object Solution_2969 {
  def minimumCoins(prices: Array[Int]): Int = {
    val n = prices.length
    val pq = mutable.PriorityQueue.empty[(Int, Int)](Ordering.by(-_._1)) += ((0, n))

    var last = 0

    (n - 1 to 0 by -1).foreach(i => {
      val next = n.min(i * 2 + 2)
      while (pq.head._2 > next) pq.dequeue()
      last = pq.head._1 + prices(i)
      pq += ((pq.head._1 + prices(i), i))
    })

    last
  }
}
