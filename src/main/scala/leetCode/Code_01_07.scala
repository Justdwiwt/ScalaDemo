package leetCode

object Code_01_07 {
  def rotate(matrix: Array[Array[Int]]): Unit = {
    matrix.indices.foreach(i => {
      (i until matrix.length).foreach(j => {
        val t = matrix(i)(j)
        matrix(i)(j) = matrix(j)(i)
        matrix(j)(i) = t
      })
      (0 until matrix.length / 2).foreach(k => {
        val t = matrix(i)(k)
        matrix(i)(k) = matrix(i)(matrix.length - k - 1)
        matrix(i)(matrix.length - k - 1) = t
      })
    })
  }
}
