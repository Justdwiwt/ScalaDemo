package leetCode._500

object Solution_492 {
  def constructRectangle(area: Int): Array[Int] = (math.sqrt(area).toInt to 1 by -1)
    .find(area % _ == 0)
    .map(m => Array(area / m, m))
    .getOrElse(Array(area, 1))
}
