package leetCode

import scala.collection.mutable

object Solution_2454 {
  def secondGreaterElement(nums: Array[Int]): Array[Int] = {
    val res = Array.fill(nums.length)(-1)
    val stack = mutable.Stack[Int]()
    val pq = mutable.PriorityQueue[(Int, Int)]()(Ordering.by[(Int, Int), Int](_._1).reverse)

    nums.indices.foreach(i => {
      while (pq.nonEmpty && pq.head._1 < nums(i)) {
        val (_, index) = pq.dequeue()
        res(index) = nums(i)
      }
      while (stack.nonEmpty && nums(stack.head) < nums(i)) {
        pq.enqueue((nums(stack.head), stack.head))
        stack.pop()
      }
      stack.push(i)
    })
    res
  }
}
