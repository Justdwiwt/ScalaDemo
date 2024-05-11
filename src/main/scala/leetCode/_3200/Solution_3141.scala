package leetCode._3200

import scala.collection.mutable

object Solution_3141 {
  def maxHammingDistances(nums: Array[Int], m: Int): Array[Int] = {
    val ma = (1 << m) - 1
    val arr = Array.fill(1 << m)(Int.MaxValue)
    val pq = mutable.PriorityQueue.empty[(Int, Int)].reverse

    nums.foreach(num => {
      val tmp = ma ^ num
      arr(tmp) = 0
      pq += ((0, tmp))
    })

    def updateDistance(cost: Int, x: Int): Unit = {
      if (arr(x) < cost) return
      (0 until m).foreach(j => {
        val tmp = (1 << j) ^ x
        if (tmp < arr.length && arr(tmp) > cost + 1) {
          arr(tmp) = cost + 1
          pq += ((cost + 1, tmp))
        }
      })
    }

    while (pq.nonEmpty) {
      val (cost, x) = pq.dequeue()
      updateDistance(cost, x)
    }

    nums.map(m - arr(_))
  }
}
