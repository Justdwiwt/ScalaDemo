package leetCode.crackingCodeInterview

object Code_16_22 {
  private val dirChar = Array('R', 'D', 'L', 'U')

  def printKMoves(K: Int): List[String] = {
    if (K < 1) return List("R")

    @scala.annotation.tailrec
    def f(k: Int, x: Int, y: Int, dir: Int, map: Map[(Int, Int), Boolean], left: Int, right: Int, down: Int, up: Int): (Int, Int, Int, Map[(Int, Int), Boolean], Int, Int, Int, Int) = {
      if (k == 0) (x, y, dir, map, left, right, down, up)
      else {
        val key = (x, y)
        val (newDir, newMap) = map.get(key) match {
          case Some(isRight) =>
            val updatedDir = if (isRight) (dir + 1) & 3 else (dir + 3) & 3
            (updatedDir, map.updated(key, !isRight))
          case None => ((dir + 1) & 3, map.updated(key, false))
        }
        val (newX, newY) = move(x, y, newDir)
        f(k - 1, newX, newY, newDir, newMap, left.min(newX), right.max(newX), down.min(newY), up.max(newY))
      }
    }

    val (finalX, finalY, finalDir, finalMap, leftBound, rightBound, downBound, upBound) =
      f(K, 0, 0, 0, Map[(Int, Int), Boolean](), 0, 0, 0, 0)

    val width = rightBound - leftBound + 1
    val height = upBound - downBound + 1
    val res = Array.fill(height, width)('_')

    finalMap.foreach { case ((x, y), isWhite) => if (!isWhite) res(upBound - y)(x - leftBound) = 'X' }
    res(upBound - finalY)(finalX - leftBound) = dirChar(finalDir)

    res.map(_.mkString).toList
  }

  private def move(x: Int, y: Int, direction: Int): (Int, Int) = direction match {
    case 0 => (x + 1, y)
    case 1 => (x, y - 1)
    case 2 => (x - 1, y)
    case 3 => (x, y + 1)
  }
}
