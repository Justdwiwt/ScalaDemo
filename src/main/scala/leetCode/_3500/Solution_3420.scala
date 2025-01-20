package leetCode._3500

import scala.collection.mutable.ListBuffer

object Solution_3420 {
  def countNonDecreasingSubarrays(nums: Array[Int], k: Int): Long = {
    val n = nums.length
    val deque = new ListBuffer[(Int, Int, Int)]()
    var res = 0L
    var cost = 0L

    ((n - 1) to 0 by -1).foreach(i => {
      val num = nums(i)
      var count = 1

      while (deque.nonEmpty && deque.head._1 <= num) {
        val (value, _, cnt) = deque.remove(0)
        count += cnt
        cost += cnt.toLong * (num.toLong - value.toLong)
      }

      deque.prepend((num, i, count))

      while (cost > k) {
        val (value, start, cnt) = deque.remove(deque.size - 1)
        val prevVal = if (start + cnt - 1 < n) nums(start + cnt - 1) else 0
        cost -= (value.toLong - prevVal.toLong)
        val newCount = cnt - 1
        if (newCount > 0) {
          deque.append((value, start, newCount))
        }
      }
      res += (deque.last._2 + deque.last._3 - i).toLong
    })
    res
  }
}
