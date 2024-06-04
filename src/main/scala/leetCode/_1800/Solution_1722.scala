package leetCode._1800

import scala.collection.immutable.Queue

object Solution_1722 {
  def minimumHammingDistance(source: Array[Int], target: Array[Int], allowedSwaps: Array[Array[Int]]): Int = {
    lazy val aSet = allowedSwaps.flatten.toSet
    lazy val aMap = allowedSwaps.toSet.flatMap((a: Array[Int]) => List(a.head -> a.last, a.last -> a.head)).groupBy(_._1).mapValues(_.map(_._2).toSet)

    @scala.annotation.tailrec
    def bfs(q: Queue[Int], v: Set[Int]): Set[Int] = {
      lazy val next = aMap(q.head) -- v
      if (q.isEmpty) v else bfs(q.tail ++ next, v ++ next)
    }

    aSet
      .iterator
      .foldLeft(Set.empty[Int], List.empty[Set[Int]]) { case ((s, l), i) =>
        lazy val next = bfs(Queue(i), Set(i))
        if (s.contains(i)) (s, l) else (s ++ next, next +: l)
      }
      ._2
      .map(_.toList)
      .map(seq => {
        lazy val (s, t) = seq
          .map(source)
          .groupBy(identity)
          .mapValues(_.size) -> seq
          .map(target)
          .groupBy(identity)
          .mapValues(_.size)

        s.iterator.foldLeft(0) { case (acc, (k, v)) => acc + (v - t.getOrElse(k, 0)).max(0) }
      })
      .sum + source
      .zip(target)
      .zipWithIndex
      .count { case ((s, t), i) => !aSet.contains(i) && s != t }
  }
}
