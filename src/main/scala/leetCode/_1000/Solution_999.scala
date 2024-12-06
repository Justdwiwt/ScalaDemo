package leetCode._1000

object Solution_999 {
  def numRookCaptures(board: Array[Array[Char]]): Int = {
    val directions = Array((0, 1), (0, -1), (1, 0), (-1, 0))
    val rookPos = (0 until 8).flatMap(i => (0 until 8).withFilter(board(i)(_) == 'R').map((i, _)))

    val (rookX, rookY) = rookPos.head

    directions.count { case (dx, dy) => Iterator
      .from(1)
      .map(i => (rookX + i * dx, rookY + i * dy))
      .takeWhile { case (x, y) => inRange(x, y) }
      .map { case (x, y) => board(x)(y) }
      .collectFirst { case ch if ch != '.' => ch }
      .contains('p')
    }
  }

  private def inRange(x: Int, y: Int): Boolean =
    0 <= x && x <= 7 && 0 <= y && y <= 7
}
