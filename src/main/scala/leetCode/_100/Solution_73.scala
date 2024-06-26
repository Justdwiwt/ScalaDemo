package leetCode._100

object Solution_73 {
  def setZeroes(matrix: Array[Array[Int]]): Unit = {
    val t = matrix.map(_.zipWithIndex).zipWithIndex.flatMap(x => x._1.map(t => (x._2 + 1, t._2 + 1, t._1)))
    val col = t.filter(_._3 == 0).map(_._2).distinct
    val row = t.filter(_._3 == 0).map(_._1).distinct
    (1 to matrix.length).foreach(r => (1 to matrix.head.length).foreach(c => if (col.contains(c) || row.contains(r)) matrix(r - 1)(c - 1) = 0))
  }
}
