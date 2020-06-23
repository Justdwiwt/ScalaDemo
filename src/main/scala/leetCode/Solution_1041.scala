package leetCode

object Solution_1041 {
  def isRobotBounded(instructions: String): Boolean = {
    val p = Array(0, 1, 0, -1)
    val q = Array(1, 0, -1, 0)
    var cur = ""
    var x = 0
    var y = 0
    var t = 0
    (0 until 4).foreach(_ => cur += instructions)
    cur.foreach({
      case 'G' =>
        x += p(t)
        y += q(t)
      case 'L' =>
        t = (t + 3) % 4
      case _ =>
        t = (t + 1) % 4
    })
    x == 0 && y == 0
  }
}
