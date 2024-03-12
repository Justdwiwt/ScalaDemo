package leetCode._1500

object Solution_1496 {
  def addPoints(p: (Int, Int), y: Char): (Int, Int) = y match {
    case 'N' => (p._1, p._2 + 1)
    case 'E' => (p._1 + 1, p._2)
    case 'S' => (p._1, p._2 - 1)
    case 'W' => (p._1 - 1, p._2)
    case _ => p
  }

  def isPathCrossing(path: String): Boolean = {
    val points = path.toArray.scanLeft((0, 0))((x, y) => addPoints(x, y))
    points.length != points.distinct.length
  }
}
