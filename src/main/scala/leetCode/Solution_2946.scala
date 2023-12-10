package leetCode

object Solution_2946 {
  def areSimilar(mat: Array[Array[Int]], k: Int): Boolean =
    mat.forall(row => row.indices.forall(i => row(i) == row((i + k) % row.length)))
}
