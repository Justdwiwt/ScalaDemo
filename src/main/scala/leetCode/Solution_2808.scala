package leetCode

import scala.collection.immutable.Queue

object Solution_2808 {
  def minimumSeconds(nums: List[Int]): Int = {
    val size = nums.size
    val positions = nums.zipWithIndex./:(Map.empty[Int, Queue[Int]]) { case (pos, (num, idx)) =>
      pos.updated(num, pos.getOrElse(num, Queue.empty) :+ idx)
    }
    val gaps = positions.map { case (_, pos) => (pos :+ pos.head + size).sliding(2).map(s => s(1) - s.head).max }
    gaps.min / 2
  }
}
