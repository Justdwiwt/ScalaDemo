package leetCode._2800

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Solution_2713 {
  def maxIncreasingCells(M: Array[Array[Int]]): Int = {
    val m = M.length
    val n = M.head.length

    val book = mutable.HashMap.empty[Int, ArrayBuffer[(Int, Int)]]

    M.indices.foreach(i => M.head.indices.foreach(j => {
      val value = M(i)(j)
      book.getOrElseUpdate(value, ArrayBuffer[(Int, Int)]()) += ((i, j))
    }))

    val R = Array.fill(m)(0)
    val C = Array.fill(n)(0)

    book.keys.toArray.sorted.foreach(x => {
      val mem = book(x).map { case (i, j) => (i, j) -> (1 + R(i).max(C(j))) }.toMap
      mem.foreach { case ((i, j), v) =>
        R(i) = v.max(R(i))
        C(j) = v.max(C(j))
      }
    })
    (R ++ C).max
  }
}
