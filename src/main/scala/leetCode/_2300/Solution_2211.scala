package leetCode._2300

object Solution_2211 {
  def countCollisions(directions: String): Int = directions.indexWhere(_ != 'L') match {
    case -1 => 0
    case h => directions.substring(h, directions.lastIndexWhere(_ != 'R') + 1).count(_ != 'S')
  }
}
