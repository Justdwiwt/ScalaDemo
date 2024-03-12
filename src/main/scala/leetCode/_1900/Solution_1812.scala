package leetCode._1900

object Solution_1812 {
  def squareIsWhite(coordinates: String): Boolean =
    ((coordinates.head ^ coordinates(1)) & 1) > 0
}
