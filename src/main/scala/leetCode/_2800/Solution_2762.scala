package leetCode._2800

import scala.collection.immutable.{Queue, TreeMap}

object Solution_2762 {
  def continuousSubarrays(nums: Array[Int]): Long =
    f(nums.toList.tail, 1, Queue(nums.head), TreeMap(nums.head -> 1), 0)

  @scala.annotation.tailrec
  private def f(nums: List[Int], size: Int, queue: Queue[Int], map: TreeMap[Int, Int], acc: Long): Long =
    if (map.lastKey - map.firstKey <= 2) nums match {
      case Nil => acc + size
      case num :: tail =>
        val nMap = map.updated(num, map.getOrElse(num, 0) + 1)
        f(tail, size + 1, queue :+ num, nMap, acc + size)
    }
    else {
      val cnt = map(queue.head)
      val nMap = if (cnt == 1) map.drop(queue.head) else map.updated(queue.head, cnt - 1)
      f(nums, size - 1, queue.tail, nMap, acc)
    }
}
