package leetCode._1400

object Solution_1337 {
  def kWeakestRows(mat: Array[Array[Int]], k: Int): Array[Int] = mat
    .map(_.sum)
    .zip(mat.indices)
    .sortBy(v => (v._1, v._2))
    .map(_._2)
    .slice(0, k)
}
