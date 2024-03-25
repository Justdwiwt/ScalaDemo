package leetCode._1600

object Solution_1503 {
  def getLastMoment(n: Int, left: Array[Int], right: Array[Int]): Int = {
    val l = left.sorted
    val r = right.sorted
    (if (l.length > 0) l(l.length - 1) else 0).max(if (r.length > 0) n - r.head else 0)
  }
}
