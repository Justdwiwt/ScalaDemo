package leetCode

object Solution_311 {
  def multiply(A: Array[Array[Int]], B: Array[Array[Int]]): Array[Array[Int]] = {
    val res = Array.ofDim[Int](A.length, B.head.length)
    A.indices.foreach(row => B.head.indices.foreach(c => B.indices.foreach(i => res(row)(c) += A(row)(i) * B(i)(c))))
    res
  }
}
