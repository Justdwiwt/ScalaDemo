package leetCode._1500

object Solution_1476 {

  class SubrectangleQueries(_rectangle: Array[Array[Int]]) {

    private val rec = _rectangle

    def updateSubrectangle(row1: Int, col1: Int, row2: Int, col2: Int, newValue: Int) {
      (row1 to row2).foreach(i => (col1 to col2).foreach(rec(i)(_) = newValue))
    }

    def getValue(row: Int, col: Int): Int = rec(row)(col)

  }

}
