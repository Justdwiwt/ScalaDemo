package leetCode

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Solution_2371 {
  def minScore(grid: Array[Array[Int]]): Array[Array[Int]] = {
    val rank = Array.fill(grid.length + grid.head.length)(0)
    val m = mutable.HashMap.empty[Int, mutable.ArrayBuffer[(Int, Int)]]

    grid.indices.foreach(i => grid.head.indices.foreach(j => m.getOrElseUpdate(grid(i)(j), ArrayBuffer()) += ((i, j))))

    m
      .toSeq
      .sortBy(_._1)
      .foreach { case (_, list) =>
        val parent = Array.tabulate(grid.length + grid.head.length)(i => i)
        val tmp = rank

        list.foreach { case (x, y) =>
          val (i, j) = (find(x, parent), find(y + grid.length, parent))
          parent(i) = j
          tmp(j) = tmp(i).max(tmp(j))
        }

        list
          .map { case (i, j) => val r = tmp(find(i, parent)) + 1; ((i, j), r) }
          .foreach { case ((i, j), r) =>
            rank(i) = r
            rank(j + grid.length) = r
            grid(i)(j) = r
          }
      }

    grid
  }

  def find(i: Int, parent: Array[Int]): Int = {
    if (parent(i) != i) parent(i) = find(parent(i), parent)
    parent(i)
  }
}
