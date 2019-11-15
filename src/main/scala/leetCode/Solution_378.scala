package leetCode

import scala.collection.mutable

object Solution_378 {
  def kthSmallest(matrix: Array[Array[Int]], k: Int): Int = {
    val q = new mutable.PriorityQueue[Int]()
    matrix.indices.foreach(i => matrix.indices.foreach(j => {
      q.enqueue(matrix(i)(j))
      if (q.size > k) q.dequeue
    }))
    q.head
  }
}
