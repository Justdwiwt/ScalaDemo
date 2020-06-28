package leetCode

object Solution_1462 {
  def checkIfPrerequisite(n: Int, prerequisites: Array[Array[Int]], queries: Array[Array[Int]]): Array[Boolean] = {
    val diff = Array.ofDim[Boolean](n, n)
    prerequisites.indices.foreach(i => diff(prerequisites(i)(0))(prerequisites(i)(1)) = true)
    (0 until n).foreach(i => (0 until n).foreach(j => (0 until n).foreach(k => if (diff(j)(i) && diff(i)(k)) diff(j)(k) = true)))
    var res = Array.empty[Boolean]
    queries.indices.foreach(i => res :+= diff(queries(i)(0))(queries(i)(1)))
    res
  }
}
