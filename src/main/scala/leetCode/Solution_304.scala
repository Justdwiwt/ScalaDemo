package leetCode

object Solution_304 {

  class NumMatrix(_matrix: Array[Array[Int]]) {

    def sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int = {
      val line = (row1 to row2).filter(_ < _matrix.length).map((_, col1))
      val point = (col1 to col2).filter(_ < _matrix.head.length).flatMap(col => line.map(rec => (rec._1, col)))
      point.foldLeft(0)((sum, point) => sum + _matrix(point._1)(point._2))
    }

  }

}
