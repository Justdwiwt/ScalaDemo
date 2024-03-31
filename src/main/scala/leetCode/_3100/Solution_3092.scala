package leetCode._3100

import scala.collection.immutable.TreeSet

object Solution_3092 {
  def mostFrequentIDs(nums: Array[Int], freq: Array[Int]): Array[Long] = nums
    .zip(freq)
    .foldLeft((Map.empty[Int, Long], TreeSet.empty[(Long, Int)], List.empty[Long])) {
      case ((map, set, acc), (n, f)) =>
        lazy val f0: Long = map.getOrElse(n, 0L)
        lazy val set1 = (if (f0 == 0L) set else set - (f0 -> n)) + (f0 + f -> n)
        (map + (n -> (f0 + f)), set1, set1.last._1 +: acc)
    }
    ._3
    .reverse
    .toArray
}
