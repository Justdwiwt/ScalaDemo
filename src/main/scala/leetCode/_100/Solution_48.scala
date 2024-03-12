package leetCode._100

object Solution_48 {
  def rotate(matrix: Array[Array[Int]]): Unit = {
    matrix.indices.foreach(i => {
      (i + 1 until matrix.length).foreach(j => {
        val t = matrix(i)(j)
        matrix(i)(j) = matrix(j)(i)
        matrix(j)(i) = t
      })
      matrix(i) = matrix(i).reverse
    })
  }
}
