package leetCode._3300

object Solution_3248 {
  def finalPositionOfSnake(n: Int, commands: List[String]): Int = commands.foldLeft(0) {
    case (x, "RIGHT") => x + 1
    case (x, "LEFT") => x - 1
    case (x, "UP") => x - n
    case (x, "DOWN") => x + n
  }
}
