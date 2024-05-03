package leetCode._400

object Solution_308 {
  class NumMatrix(private var matrix: Array[Array[Int]]) {
    private var rowSumArr: Array[Array[Int]] = _

    if (matrix == null || matrix.isEmpty || matrix(0).length == 0) rowSumArr = Array.ofDim[Int](0, 0)
    else {
      val rowCount = matrix.length
      val colCount = matrix(0).length
      rowSumArr = Array.ofDim[Int](rowCount, colCount)
      matrix.indices.foreach(i => {
        rowSumArr(i)(0) = matrix(i)(0)
        matrix.head.indices.drop(1).foreach(j => rowSumArr(i)(j) = rowSumArr(i)(j - 1) + matrix(i)(j))
      })
    }

    def update(row: Int, col: Int, `val`: Int): Unit = {
      matrix(row)(col) = `val`
      var fromCol = col
      if (col == 0) {
        rowSumArr(row)(col) = matrix(row)(col)
        fromCol = col + 1
      }
      (fromCol until matrix.head.length).foreach(j => rowSumArr(row)(j) = rowSumArr(row)(j - 1) + matrix(row)(j))
    }

    def sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int = {
      var sum = 0
      (row1 to row2).foreach(i => sum += (if (col1 == 0) rowSumArr(i)(col2) else rowSumArr(i)(col2) - rowSumArr(i)(col1 - 1)))
      sum
    }
  }
}
