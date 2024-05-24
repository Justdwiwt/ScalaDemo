package leetCode._3000

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Solution_2940 {
  def leftmostBuildingQueries(heights: Array[Int], queries: Array[Array[Int]]): Array[Int] = {
    val n = heights.length
    val m = queries.length
    val res = Array.fill(m)(-1)
    val left = Array.fill(n)(ArrayBuffer.empty[(Int, Int)])

    queries.indices.foreach(idx => {
      var i = queries(idx)(0)
      var j = queries(idx)(1)
      if (i > j) {
        val temp = i
        i = j
        j = temp
      }
      if (i == j || heights(i) < heights(j)) res(idx) = j
      else left(j).append((heights(i), idx))
    })

    val pq = mutable.PriorityQueue.empty[(Int, Int)](Ordering.by(-_._1))

    heights.indices.foreach(i => {
      while (pq.nonEmpty && pq.head._1 < heights(i)) res(pq.dequeue()._2) = i
      left(i).foreach(pq.+=)
    })
    res
  }
}
