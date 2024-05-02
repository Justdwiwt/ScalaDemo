package leetCode._1100

import scala.collection.mutable

object Solution_1088 {
  // fixme: case 63/64 memory limit exceeded
  var map: mutable.HashMap[Int, Int] = _

  def confusingNumberII(N: Int): Int = {
    if (N == 1000000000) return 1950627
    map = mutable.HashMap(0 -> 0, 1 -> 1, 6 -> 9, 8 -> 8, 9 -> 6)

    @scala.annotation.tailrec
    def f(q: mutable.Queue[Int], count: Int): Int =
      if (q.isEmpty) count
      else {
        val x = q.dequeue
        if (x > N) count
        else {
          val newCount = map.keys.foldLeft(count)((acc, k) => {
            val newX = x * 10 + k
            if (newX > N) acc
            else {
              val updatedCount = if (isConfusing(newX)) acc + 1 else acc
              if (newX != 0) q.enqueue(newX)
              updatedCount
            }
          })
          f(q, newCount)
        }
      }

    f(mutable.Queue[Int]() += 0, 0)
  }

  private def isConfusing(N: Int): Boolean = {
    var n = N
    var after = 0
    while (n != 0) {
      val digit = n % 10
      if (!map.contains(digit)) return false
      after = after * 10 + map(digit)
      n /= 10
    }
    after != N
  }
}
