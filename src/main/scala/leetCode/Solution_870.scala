package leetCode

import scala.collection.mutable

object Solution_870 {
  def advantageCount(A: Array[Int], B: Array[Int]): Array[Int] = {
    var left = 0
    val a = A.sorted
    var right = A.length - 1
    val res = Array.fill(A.length)(0)
    val q = new mutable.PriorityQueue[(Int, Int)]()
    a.indices.foreach(i => q.enqueue((B(i), i)))
    while (q.nonEmpty) {
      val v = q.head._1
      val idx = q.head._2
      q.dequeue
      if (a(right) > v) {
        res(idx) = a(right)
        right -= 1
      } else {
        res(idx) = a(left)
        left += 1
      }
    }
    res
  }
}
