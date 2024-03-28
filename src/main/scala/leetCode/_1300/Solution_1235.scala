package leetCode._1300

import scala.collection.immutable.TreeMap

object Solution_1235 {
  def jobScheduling(startTime: Array[Int], endTime: Array[Int], profit: Array[Int]): Int = startTime
    .indices
    .map(i => (startTime(i), endTime(i), profit(i)))
    .sortBy(_._2)
    .iterator
    .foldLeft(TreeMap.empty[Int, Int]) { case (map, (s, e, p)) =>
      map.updated(e, (map.to(s).lastOption.map(_._2).getOrElse(0) + p).max(map.to(e).lastOption.map(_._2).getOrElse(0)))
    }
    .last
    ._2
}
