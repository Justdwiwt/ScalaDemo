package leetCode

object Solution_73 {
  def setZeroes(matrix: Array[Array[Int]]): Unit = {
    if (matrix.isEmpty || matrix(0).isEmpty) return
    var row = false
    var col = false
    matrix.indices.foreach(i => if (matrix(i)(0) == 0) col = true)
    matrix(0).indices.foreach(i => if (matrix(0)(i) == 0) row = true)
    (1 until matrix.length).foreach(i => (1 until matrix(0).length).foreach(j => {
      if (matrix(i)(j) == 0) {
        matrix(0)(j) = 0
        matrix(i)(0) = 0
      }
    }))
    (1 until matrix.length).foreach(i => (1 until matrix(0).length).foreach(j => if (matrix(0)(j) == 0 || matrix(i)(0) == 0) matrix(i)(j) = 0))
    if (row) matrix(0).indices.foreach(i => matrix(0)(i) = 0)
    if (col) matrix.indices.foreach(i => matrix(i)(0) = 0)
  }
}
