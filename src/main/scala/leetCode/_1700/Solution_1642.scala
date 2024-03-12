package leetCode._1700

import scala.collection.mutable

object Solution_1642 {
  def furthestBuilding(heights: Array[Int], bricks: Int, ladders: Int): Int = {
    val pq = mutable.PriorityQueue[Int]()(Ordering[Int].reverse)

    @scala.annotation.tailrec
    def f(i: Int, need: Int): Int = {
      if (i >= heights.length) i - 1
      else {
        val delta = heights(i) - heights(i - 1)
        if (delta <= 0) f(i + 1, need)
        else {
          pq += delta
          if (pq.size <= ladders) f(i + 1, need)
          else {
            val newBricksNeeded = need + pq.dequeue()
            if (newBricksNeeded <= bricks) f(i + 1, newBricksNeeded)
            else i - 1
          }
        }
      }
    }

    f(1, 0)
  }
}
