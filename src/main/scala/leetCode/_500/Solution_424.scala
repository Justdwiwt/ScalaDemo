package leetCode._500

import scala.collection.immutable.Queue

object Solution_424 {
  def characterReplacement(s: String, k: Int): Int =
    f(s.toList.tail, k, Queue(s.head), Map(s.head -> 1), 1)

  @scala.annotation.tailrec
  private def f(word: List[Char], k: Int, q: Queue[Char], map: Map[Char, Int], max: Int): Int = {
    val size = map.values.sum
    if (size - map.values.max > k) f(word, k, q.tail, map.updated(q.head, map(q.head) - 1), max)
    else word match {
      case Nil => max.max(size)
      case c :: tail => f(tail, k, q :+ c, map.updated(c, map.getOrElse(c, 0) + 1), max.max(size))
    }
  }
}
