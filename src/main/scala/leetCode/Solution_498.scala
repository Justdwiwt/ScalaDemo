package leetCode

object Solution_498 {
  def findDiagonalOrder(A: Array[Array[Int]]): Array[Int] = {
    val n = A.length
    if (n == 0) return Array.empty[Int]
    val m = A(0).length
    val fre = Array.fill(m + n - 1)(List.empty[Int])

    (0 until n).foreach(i => (0 until m).foreach(j => fre(i + j) ::= A(i)(j)))

    (0 to m + n - 2).toArray flatMap { i =>
      i % 2 match {
        case 0 => fre(i)
        case 1 => fre(i).reverse
      }
    }
  }
}
