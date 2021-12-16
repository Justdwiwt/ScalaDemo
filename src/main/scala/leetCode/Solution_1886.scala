package leetCode

object Solution_1886 {
  def findRotation(mat: Array[Array[Int]], target: Array[Array[Int]]): Boolean = {
    isSame(mat, target) || isSame(mat, matrix(target)) || isSame(mat, matrix(matrix(target))) || isSame(mat, matrix(matrix(matrix(target))))
  }

  def isSame(a: Array[Array[Int]], b: Array[Array[Int]]): Boolean = {
    a.indices.foreach(i => a.indices.foreach(j => if (a(i)(j) != b(i)(j)) return false))
    true
  }

  def matrix(a: Array[Array[Int]]): Array[Array[Int]] = {
    val res = Array.fill(a.length, a.length)(0)
    a.indices.foreach(i => a.indices.foreach(j => res(j)(a.length - 1 - i) = a(i)(j)))
    res
  }
}
