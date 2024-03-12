package leetCode._1700

object Solution_1643 {
  val cit: Array[Long] => Array[Long] = (_: Array[Long]).scanLeft((0L, 0L)) { case ((p, _), n) => (n, p + n) }.map(_._2).tail :+ 1L
  val it: Array[Array[Long]] = Iterator.iterate(Array(0L, 1L))(cit).take(31).toArray

  def f(h: Int, v: Int, k: Long): String =
    if (h + v == 0) ""
    else if (k < it(h + v - 1)(h)) 'H' +: f(h - 1, v, k)
    else 'V' +: f(h, v - 1, k - it(h + v - 1)(h))

  def kthSmallestPath(destination: Array[Int], k: Int): String = {
    val Array(v, h) = destination
    f(h, v, k - 1)
  }
}
