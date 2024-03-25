package leetCode._1600

object Solution_1582 {
  def numSpecial(mat: Array[Array[Int]]): Int = mat
    .map(_.zipWithIndex.filter(_._1 == 1))
    .filter(_.length == 1)
    .map(_.head._2)
    .count(col => mat.map(_ (col)).sum == 1)
}
