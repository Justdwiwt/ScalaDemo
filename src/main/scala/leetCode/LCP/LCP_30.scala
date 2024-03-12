package leetCode.LCP

import java.util.PriorityQueue

object LCP_30 {
  def magicTower(nums: Array[Int]): Int = {
    val pq = new PriorityQueue[Int]()
    var res = 0L
    var cur = 1L
    val sum = nums.sum.toLong
    if (sum < 0) return -1
    nums.foreach(x => {
      cur += x
      if (x < 0) pq.offer(x)
      if (cur <= 0) {
        cur -= pq.poll()
        res += 1
      }
    })
    res.toInt
  }
}
