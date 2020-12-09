package leetCode

object Solution_498 {
  def findDiagonalOrder(A: Array[Array[Int]]): Array[Int] = {
    if (A.isEmpty) return Array.empty[Int]
    val arr = Array.fill(A.head.length + A.length - 1)(List.empty[Int])
    A.indices.foreach(i => A.head.indices.foreach(j => arr(i + j) ::= A(i)(j)))
    (0 to A.head.length + A.length - 2).toArray.flatMap(i => i % 2 match {
      case 0 => arr(i)
      case 1 => arr(i).reverse
    })
  }
}
