package leetCode

object Solution_434 {
  def countSegments(s: String): Int = s
    .split(" ")
    .count(_.nonEmpty)
}
