package leetCode._2400

import scala.collection.mutable

object Solution_2387 {
  def matrixMedian(grid: Array[Array[Int]]): Int = {
    val m = grid.length
    val n = grid.head.length
    val pq = mutable.PriorityQueue.empty[(Int, Int, Int)](Ordering.by(p => grid(p._1)(p._2)))
    grid.indices.foreach(i => grid.head.indices.foreach(j => pq.enqueue((i, j, grid(i)(j)))))
    val target = (m * n) / 2
    Iterator.continually(pq.dequeue()).drop(target).next()._3
  }
}
