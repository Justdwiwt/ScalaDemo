package leetCode._1700

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Solution_1632 {
  def matrixRankTransform(matrix: Array[Array[Int]]): Array[Array[Int]] = {
    val rank = Array.fill(matrix.length + matrix.head.length)(0)
    val m = new mutable.HashMap[Int, mutable.ArrayBuffer[(Int, Int)]]()

    matrix.indices.foreach(i => matrix.head.indices.foreach(j => m.getOrElseUpdate(matrix(i)(j), ArrayBuffer()) += ((i, j))))

    m
      .toSeq
      .sortBy(_._1)
      .foreach { case (_, list) =>
        val parent = Array.tabulate(matrix.length + matrix.head.length)(i => i)
        val tmp = rank

        list.foreach { case (x, y) =>
          val (i, j) = (find(x, parent), find(y + matrix.length, parent))
          parent(i) = j
          tmp(j) = tmp(i).max(tmp(j))
        }

        list
          .map { case (i, j) => val r = tmp(find(i, parent)) + 1; ((i, j), r) }
          .foreach { case ((i, j), r) =>
            rank(i) = r
            rank(j + matrix.length) = r
            matrix(i)(j) = r
          }
      }

    matrix
  }

  private def find(i: Int, parent: Array[Int]): Int = {
    if (parent(i) != i) parent(i) = find(parent(i), parent)
    parent(i)
  }
}
