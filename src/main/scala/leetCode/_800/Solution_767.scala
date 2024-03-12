package leetCode._800

import scala.collection.mutable

object Solution_767 {
  def reorganizeString(S: String): String = {
    if (S.length <= 1) return S
    val pq = mutable.PriorityQueue[(Char, Int)]()(Ordering.by(_._2))
    val cnt = S.groupBy(identity).mapValues(_.length)
    cnt.foreach(pq += _)
    val op: Option[(Char, Int)] = None
    S.indices./:("", op) { case ((acc, opt), _) =>
      if (pq.isEmpty) return ""
      val next = pq.dequeue
      if (opt.nonEmpty) pq += opt.get
      val nextOp = if (next._2 > 1) Some((next._1, next._2 - 1)) else None
      (acc + next._1, nextOp)
    }._1
  }
}
