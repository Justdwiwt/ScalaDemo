package leetCode

object Solution_1337 {
  def kWeakestRows(mat: Array[Array[Int]], k: Int): Array[Int] = {
    val t = Array.ofDim[Int](mat.length, 2)
    mat.indices.foreach(i => mat(0).indices.foreach(j => {
      t(i)(0) = i
      if (mat(i)(j) == 1) t(i)(1) += 1
    }))
    val arr = t.sorted((o1: Array[Int], o2: Array[Int]) => o1(1) - o2(1))
    val res = Array.fill(k)(0)
    (0 until k).foreach(i => res(i) = arr(i)(0))
    res
  }
}
