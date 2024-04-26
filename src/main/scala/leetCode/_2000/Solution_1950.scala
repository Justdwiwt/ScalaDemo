package leetCode._2000

import scala.collection.mutable

object Solution_1950 {
  def findMaximums(nums: Array[Int]): Array[Int] = {
    val n = nums.length
    val res = Array.fill(n)(0)
    val stack = mutable.Stack[Int]()
    val pq = new java.util.PriorityQueue[(Int, Int)]((a: (Int, Int), b: (Int, Int)) => b._1 - a._1)

    nums.indices.foreach(i => {
      while (stack.nonEmpty && nums(stack.top) > nums(i)) {
        val tmp = stack.pop()
        val left = if (stack.isEmpty) 0 else stack.top + 1
        val right = i - 1
        pq.add((right - left + 1, nums(tmp)))
      }
      stack.push(i)
    })

    while (stack.nonEmpty) {
      val tmp = stack.pop()
      val left = if (stack.isEmpty) 0 else stack.top + 1
      val right = n - 1
      pq.add((right - left + 1, nums(tmp)))
    }

    var max = 0
    nums.indices.reverse.foreach(i => {
      while (!pq.isEmpty && pq.peek._1 >= i + 1) max = max.max(pq.poll()._2)
      res(i) = max
    })

    res
  }
}
