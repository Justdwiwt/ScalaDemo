package leetCode._3700

object Solution_3699 {
  def zigZagArrays(n: Int, l: Int, r: Int): Int = {
    val M = 1000000007
    val k = r - l + 1

    val f = (1 until n).foldLeft(Vector.fill(k)(1L))((cur, _) => cur
      .scanLeft(0L)(_ + _)
      .init
      .map(_ % M)
      .reverse
    )

    ((f.sum % M) * 2 % M).toInt
  }
}
