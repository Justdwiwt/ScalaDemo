package leetCode._500

import scala.collection.mutable

object Solution_414 {
  def thirdMax(nums: Array[Int]): Int = {
    val pq = mutable.PriorityQueue.empty[Int](Ordering[Int].reverse)
    val st = mutable.HashSet.empty[Int]
    nums.foreach(i => {
      if (st.add(i)) {
        pq += i
        if (pq.size > 3) pq.dequeue()
      }
    })
    if (pq.size == 2) pq.dequeue()
    pq.dequeue()
  }
}
