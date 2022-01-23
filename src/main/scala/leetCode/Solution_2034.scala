package leetCode

import scala.collection.mutable

object Solution_2034 {
  class StockPrice {
    val m, p = mutable.TreeMap.empty[Int, Int]((a, b) => Integer.compare(a, b))

    def update(timestamp: Int, price: Int): Unit = {
      p += price -> (p.getOrElse(price, 0) + 1)
      if (!m.contains(timestamp)) m += timestamp -> price
      else {
        val t = m(timestamp)
        m += timestamp -> price
        p += t -> (p(t) - 1)
        if (p(t) == 0) p -= t
      }
    }

    def current(): Int = m.last._2

    def maximum(): Int = p.lastKey

    def minimum(): Int = p.firstKey
  }
}
