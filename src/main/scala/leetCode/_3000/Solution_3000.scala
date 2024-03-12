package leetCode._3000

object Solution_3000 {
  def areaOfMaxDiagonal(dimensions: Array[Array[Int]]): Int = dimensions
    .map { case Array(length, width, _*) => (length * width, math.sqrt(length * length + width * width)) }
    .sortBy { case (square, diagonal) => (-1 * diagonal, -1 * square) }
    .headOption
    .map(_._1)
    .getOrElse(0)
}
