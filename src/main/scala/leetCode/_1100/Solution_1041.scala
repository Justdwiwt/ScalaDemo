package leetCode._1100

object Solution_1041 {
  def isRobotBounded(instructions: String): Boolean = {
    val dir = Array(0 -> 1, 1 -> 0, 0 -> -1, -1 -> 0)
    val (id, a, b) = instructions.foldLeft((0, 0, 0)) {
      case ((dId, x, y), ins) => ins match {
        case 'L' => ((dId + 3) % 4, x, y)
        case 'R' => ((dId + 1) % 4, x, y)
        case _ =>
          val (i, j) = dir(dId)
          (dId, x + i, y + j)
      }
    }
    (a == 0 && b == 0) || id != 0
  }
}
