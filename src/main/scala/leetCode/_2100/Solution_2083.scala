package leetCode._2100

object Solution_2083 {
  def numberOfSubstrings(s: String): Long = {
    val cnt = s.groupBy(identity).mapValues(_.length).map { case (a, b) => (a, b.toLong) }
    var res = 0L
    cnt.foreach { case (_, v) => res += (v * (v + 1)) / 2 }
    res
  }
}
