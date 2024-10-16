package leetCode._3400

object Solution_3317 {
  val M: Int = 1000000007
  val MX: Int = 1001

  val s: Array[Array[Long]] = Array.ofDim[Long](MX, MX)
  s(0)(0) = 1
  (1 until MX).foreach(i => (1 to i).foreach(j => s(i)(j) = (s(i - 1)(j - 1) + j * s(i - 1)(j) % M) % M))

  def numberOfWays(n: Int, x: Int, y: Int): Int = (1 to n.min(x)).foldLeft((0L, 1L, 1L)) {
    case ((ans, perm, pow_y), i) =>
      val newPerm = perm * (x + 1 - i) % M
      val newPow_y = pow_y * y % M
      val newAns = ans + newPerm * s(n)(i) % M * newPow_y % M
      (newAns % M, newPerm, newPow_y)
  }._1.toInt
}
