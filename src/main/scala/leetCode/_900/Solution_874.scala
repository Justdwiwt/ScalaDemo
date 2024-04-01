package leetCode._900

object Solution_874 {
  private val dir: Array[Direction] = Array(Direction(0, 1), Direction(1, 0), Direction(0, -1), Direction(-1, 0))

  case class Direction(x: Int, y: Int)

  case class Position(x: Int, y: Int) {
    def next(distance: Int, direction: Direction): Stream[Position] =
      (1 to distance).toStream.map(i => Position(x + i * direction.x, y + i * direction.y))
  }

  def robotSim(commands: Array[Int], obstacles: Array[Array[Int]]): Int = {
    val indexedObstacles = obstacles.toStream.map(x => Position(x(0), x(1))).toSet
    var pos = Position(0, 0)
    var di = 0
    var max = 0
    commands.foreach {
      case -2 => di = (di + 3) % 4
      case -1 => di = (di + 1) % 4
      case distance => pos
        .next(distance, dir(di))
        .takeWhile(!indexedObstacles.contains(_))
        .lastOption
        .foreach(pos = _)
        max = max.max(pos.x * pos.x + pos.y * pos.y)
    }
    max
  }
}
