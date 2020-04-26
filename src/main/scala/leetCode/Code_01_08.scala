package leetCode

object Code_01_08 {
  def setZeroes(matrix: Array[Array[Int]]): Unit = {
    val t = Array.ofDim[Int](matrix.length, matrix(0).length)
    matrix.indices.foreach(i => matrix(0).indices.foreach(j => t(i)(j) = matrix(i)(j)))
    matrix.indices.foreach(i => matrix(0).indices.foreach(j => {
      if (t(i)(j) == 0) {
        matrix.indices.foreach(m => matrix(m)(j) = 0)
        matrix(0).indices.foreach(n => matrix(i)(n) = 0)
      }
    }))
  }
}
