package leetCode._2300

import scala.collection.mutable

object Solution_2208 {
  def halveArray(nums: Array[Int]): Int = {
    val pq = mutable.PriorityQueue(nums.map(_.toDouble): _*)
    val target = nums.map(_.toDouble).sum / 2

    @scala.annotation.tailrec
    def f(removed: Double, step: Int): Int =
      if (removed >= target) step
      else {
        val highest = pq.dequeue()
        pq += (highest / 2)
        f(removed + highest / 2, step + 1)
      }

    f(removed = 0, step = 0)
  }
}
