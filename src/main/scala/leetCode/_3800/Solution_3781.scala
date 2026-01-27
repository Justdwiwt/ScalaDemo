package leetCode._3800

object Solution_3781 {
  def maximumScore(nums: Array[Int], s: String): Long = nums
    .iterator
    .zip(s.iterator)
    .foldLeft((0L, collection.mutable.PriorityQueue.empty[Int])) {
      case ((ans, pq), (x, ch)) =>
        pq += x
        if (ch == '1') (ans + pq.dequeue(), pq)
        else (ans, pq)
    }
    ._1
}
