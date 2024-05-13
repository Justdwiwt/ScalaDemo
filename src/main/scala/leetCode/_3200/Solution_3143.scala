package leetCode._3200

object Solution_3143 {
  private val Limit = 2

  def maxPointsInsideSquare(points: Array[Array[Int]], s: String): Int = {
    val maxAbsPoints = points.map(_.map(_.abs).max)
    val sorted = s.zip(maxAbsPoints).toList.sorted

    @scala.annotation.tailrec
    def computeSquare(characters: List[(Char, Int)], lastChar: Char, count: Int, square: Int): Int = characters match {
      case Nil => square
      case (ch, d) :: tail =>
        if (ch == lastChar && count < Limit) computeSquare(tail, lastChar, count + 1, square.min(d - 1))
        else computeSquare(tail, ch, 1, square)
    }

    val square = computeSquare(sorted.tail, sorted.head._1, 1, Int.MaxValue)
    sorted.count(_._2 <= square)
  }
}
