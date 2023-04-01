package leetCode

object Solution_2596 {
  def checkValidGrid(grid: Array[Array[Int]]): Boolean = {
    if (grid.head.head != 0) return false
    val res = grid.map(_.zipWithIndex.toList).zipWithIndex.flatMap(n => n._1.map(m => (m._1, m._2, n._2))).toList.sortBy(_._1).map(n => (n._2, n._3))
    res.zip(res.tail).forall(n => ((n._2._2 - n._1._2).abs == 1 && (n._2._1 - n._1._1).abs == 2) || ((n._2._2 - n._1._2).abs == 2 && (n._2._1 - n._1._1).abs == 1))
  }
}
