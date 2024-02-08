package leetCode

object Solution_3019 {
  def countKeyChanges(s: String): Int = s
    .toLowerCase
    .zip(s.toLowerCase.drop(1))
    .count(n => n._2 != n._1)
}
