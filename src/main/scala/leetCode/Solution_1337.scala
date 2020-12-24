package leetCode

object Solution_1337 {
  def kWeakestRows(mat: Array[Array[Int]], k: Int): Array[Int] = mat
    .map(arr => arr.sum)
    .zip(mat.indices)
    .sortBy(v => (v._1, v._2))
    .map(v => v._2)
    .slice(0, k)
}
