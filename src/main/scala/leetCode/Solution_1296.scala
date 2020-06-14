package leetCode

import java.util

object Solution_1296 {
  def isPossibleDivide(nums: Array[Int], k: Int): Boolean = {
    if (nums.length % k != 0) return false
    val pq = new util.PriorityQueue[Int]()
    nums.foreach(i => pq.offer(i))
    while (!pq.isEmpty) {
      val top = pq.poll()
      (1 until k).foreach(i => if (!pq.remove(top + i)) return false)
    }
    true
  }
}
