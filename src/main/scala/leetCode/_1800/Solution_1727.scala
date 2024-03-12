package leetCode._1800

object Solution_1727 {
  def largestSubmatrix(matrix: Array[Array[Int]]): Int = {
    var res = 0
    val arr = Array.fill(matrix.head.length)(0)
    matrix.indices.foreach(i => {
      matrix.head.indices.foreach(j => arr(j) = if (matrix(i)(j) == 0) 0 else arr(j) + 1)
      val sorted = arr.sorted
      matrix.head.indices.foreach(j => res = res.max(sorted(j) * (matrix.head.length - j)))
    })
    res
  }
}
