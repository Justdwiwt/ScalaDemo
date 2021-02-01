package leetCode

object Solution_867 {
  def transpose(A: Array[Array[Int]]): Array[Array[Int]] = A
    .toList
    .map(_.toList)
    .transpose
    .map(_.toArray)
    .toArray
}
