package leetCode._2100

import scala.collection.Searching.search

object Solution_2070 {
  def maximumBeauty(items: Array[Array[Int]], queries: Array[Int]): Array[Int] = {
    val beauty = items
      .sortBy { case Array(price, beauty) => (price, beauty) }
      .scanLeft((0, 0)) { case ((_, maxBeauty), Array(price, beauty)) => (price, beauty.max(maxBeauty)) }

    queries.map(price => {
      val idx = beauty.search((price, Int.MaxValue)).insertionPoint
      beauty(idx - 1)._2
    })
  }
}
