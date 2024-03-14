package leetCode._2800

import scala.collection.mutable

object Solution_2713 {
  def maxIncreasingCells(mat: Array[Array[Int]]): Int = {
    val (m, n) = (mat.length, mat.head.length)

    val tm = mutable.TreeMap.empty[Int, Seq[(Int, Int)]].withDefaultValue(Seq.empty)
    mat.indices.flatMap(i => mat.head.indices.map(j => tm.update(mat(i)(j), tm(mat(i)(j)) :+ (i, j))))

    val dp = Array.fill(m, n)(0)
    val res = Array.fill(m + n)(0)
    tm.foreach { case (_, pos) =>
      pos.foreach { case (i, j) => dp(i)(j) = res(i).max(res(m + j)) + 1 }
      pos.foreach { case (i, j) =>
        res(m + j) = res(m + j).max(dp(i)(j))
        res(i) = res(i).max(dp(i)(j))
      }
    }

    res.max
  }
}
