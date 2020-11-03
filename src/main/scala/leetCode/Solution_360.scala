package leetCode

import scala.collection.mutable

object Solution_360 {
  def sortTransformedArray(nums: Array[Int], a: Int, b: Int, c: Int): Array[Int] = {
    var pq = mutable.PriorityQueue.empty[Int]
    val res = Array.fill(nums.length)(0)
    nums.indices.foreach(i => pq += (a * nums(i) * nums(i) + b * nums(i) + c))
    nums.indices.foreach(i => {
      res(i) = pq.head
      pq.dequeue()
    })
    res.reverse
  }
}
