package leetCode

object Solution_867 {
  def transpose(A: Array[Array[Int]]): Array[Array[Int]] = {
    val res = Array.fill(A(0).length, A.length)(0)
    A.indices.foreach(i => A(0).indices.foreach(j => res(j)(i) = A(i)(j)))
    res
  }
}
