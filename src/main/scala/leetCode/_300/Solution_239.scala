package leetCode._300

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Solution_239 {
  def maxSlidingWindow(nums: Array[Int], k: Int): Array[Int] = {
    val res = new ArrayBuffer[Int]()
    val q = new mutable.PriorityQueue[(Int, Int)]()
    nums.indices.foreach(i => {
      while (q.nonEmpty && q.head._2 <= i - k) q.dequeue
      q.enqueue((nums(i), i))
      if (i >= k - 1) res.append(q.head._1)
    })
    res.toArray
  }
}
