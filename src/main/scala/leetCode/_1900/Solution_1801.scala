package leetCode._1900

object Solution_1801 {
  private val M = 1000000007

  def getNumberOfBacklogOrders(orders: Array[Array[Int]]): Int = {
    val sides = Vector(
      collection.mutable.PriorityQueue.empty[(Int, Long)],
      collection.mutable.PriorityQueue.empty[(Int, Long)]
        (Ordering.by[(Int, Long), Int](_._1).reverse)
    )

    @scala.annotation.tailrec
    def matchOrders(): Unit = {
      if (sides.forall(_.nonEmpty)) {
        val b = sides.head.dequeue
        val s = sides(1).dequeue
        if (b._1 < s._1) {
          sides(0).enqueue(b)
          sides(1).enqueue(s)
        } else {
          lazy val q = b._2.min(s._2)
          if (b._2 > q) sides.head.enqueue((b._1, b._2 - q))
          if (s._2 > q) sides(1).enqueue((s._1, s._2 - q))
          matchOrders()
        }
      }
    }

    @scala.annotation.tailrec
    def f(seq: Seq[Seq[Int]]): Unit = {
      matchOrders()
      if (seq.nonEmpty) {
        lazy val Seq(p, q, side) = seq.head
        sides(side).enqueue((p, q))
        f(seq.tail)
      }
    }

    f(orders.iterator.map(_.toSeq).toList)
    (sides.map(_.map(_._2).sum).sum % M).toInt
  }
}
