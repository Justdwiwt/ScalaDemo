package leetCode._2900

import scala.collection.mutable

object Solution_2831 {
  def longestEqualSubarray(nums: List[Int], k: Int): Int = {
    var res = 0
    val q = mutable.Map.empty[Int, mutable.Queue[Int]]

    nums.zipWithIndex.foreach { case (c, i) =>
      if (!q.contains(c)) q(c) = mutable.Queue.empty[Int]
      q(c).enqueue(i)
    }

    q.keys.foreach(c => {
      val lst = mutable.Queue.empty[Int]
      var s = 0
      q(c).zipWithIndex.foreach { case (i, _) =>
        if (lst.nonEmpty) s += i - lst.last - 1
        lst.enqueue(i)
        while (s > k) {
          val i0 = lst.dequeue()
          s -= lst.front - i0 - 1
        }
        res = res.max(lst.length)
      }
    })
    res
  }
}
