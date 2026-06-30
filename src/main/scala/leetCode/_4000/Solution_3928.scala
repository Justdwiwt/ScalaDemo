package leetCode._4000

import scala.collection.mutable

object Solution_3928 {
  private def dijkstra(g: Array[mutable.ArrayBuffer[(Int, Int, Int)]], start: Int, limit: Int, useTax: Boolean): Array[Long] = {
    val n = g.length
    val dis = Array.fill[Long](n)(limit.toLong)
    dis(start) = 0L

    implicit val ord: Ordering[(Long, Int)] =
      Ordering.by[(Long, Int), Long](_._1).reverse

    val pq = mutable.PriorityQueue[(Long, Int)]()
    pq.enqueue((0L, start))

    while (pq.nonEmpty) {
      val (dx, x) = pq.dequeue()

      if (dx == dis(x)) g(x).foreach {
        case (y, cost, tax) =>
          val w =
            if (useTax) cost.toLong * tax
            else cost.toLong

          val nd = dx + w

          if (nd < dis(y)) {
            dis(y) = nd
            pq.enqueue((nd, y))
          }
      }
    }

    dis
  }

  def minCost(n: Int, prices: Array[Int], roads: Array[Array[Int]]): Array[Int] = {
    val g = Array.fill(n)(mutable.ArrayBuffer.empty[(Int, Int, Int)])

    roads.foreach { r =>
      val x = r(0)
      val y = r(1)
      val cost = r(2)
      val tax = r(3)

      g(x) += ((y, cost, tax))
      g(y) += ((x, cost, tax))
    }

    Array.tabulate(n) { start =>
      val price = prices(start)

      val dis1 = dijkstra(g, start, price, useTax = false)
      val dis2 = dijkstra(g, start, price, useTax = true)

      var ans = Long.MaxValue
      var j = 0

      while (j < n) {
        ans = math.min(ans, prices(j).toLong + dis1(j) + dis2(j))
        j += 1
      }

      ans.toInt
    }
  }
}
