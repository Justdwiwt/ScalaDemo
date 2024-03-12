package leetCode._500

object Solution_434 {
  def countSegments(s: String): Int = s
    .split(" ")
    .count(_.nonEmpty)
}
