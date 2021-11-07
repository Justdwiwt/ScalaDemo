package leetCode

import scala.collection.mutable

object Solution_2059 {
  def minimumOperations(nums: Array[Int], start: Int, goal: Int): Int = {
    val arr = Array.fill(1001)(-1)
    arr(start) = 0
    val q = mutable.Queue(start)
    while (q.nonEmpty) {
      val cur = q.dequeue()
      val d = arr(cur)
      nums.foreach(num =>
        Array(num + cur, cur - num, cur ^ num).foreach(next =>
          if (next == goal) return d + 1
          else if (0 <= next && next <= 1000 && arr(next) == -1) {
            arr(next) = d + 1
            q.enqueue(next)
          })
      )
    }
    -1
  }
}
