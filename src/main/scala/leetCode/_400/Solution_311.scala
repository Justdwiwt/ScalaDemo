package leetCode._400

object Solution_311 {
  def multiply(A: Array[Array[Int]], B: Array[Array[Int]]): Array[Array[Int]] = A
    .indices.map(row =>
      B.head.indices.map(c =>
        B.indices.foldLeft(0)((acc, i) => acc + A(row)(i) * B(i)(c))).toArray).toArray
}
