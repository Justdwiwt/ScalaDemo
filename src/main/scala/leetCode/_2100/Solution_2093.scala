package leetCode._2100

import scala.collection.mutable

object Solution_2093 {
  def minimumCost(n: Int, highways: Array[Array[Int]], discounts: Int): Int = {
    val arr = Array.fill(n)(List.empty[(Int, Int)])
    highways.foreach { case Array(u, v, w) =>
      arr(u) ::= (v, w)
      arr(v) ::= (u, w)
    }

    val pq = mutable.PriorityQueue[(Int, Int, Int)]()(Ordering.by(-_._1))
    val dist = Array.fill(n, discounts + 1)(Int.MaxValue)

    pq.enqueue((0, 0, 0))

    @scala.annotation.tailrec
    def f: Int =
      if (pq.isEmpty) -1
      else {
        val (curCost, curId, curDiscount) = pq.dequeue()
        if (curDiscount > discounts) f
        else if (curId == n - 1) curCost
        else if (curCost < dist(curId)(curDiscount)) {
          dist(curId)(curDiscount) = curCost
          arr(curId).foreach { case (nextId, weight) =>
            pq.enqueue((curCost + weight, nextId, curDiscount))
            pq.enqueue((curCost + weight / 2, nextId, curDiscount + 1))
          }
          f
        } else f
      }

    f
  }
}
