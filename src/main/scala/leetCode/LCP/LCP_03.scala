package leetCode.LCP

object LCP_03 {
  def robot(command: String, obstacles: Array[Array[Int]], x: Int, y: Int): Boolean = {
    var x1 = 0
    var y1 = 0
    command.indices.foreach(i => {
      if (command(i) == 'U') y1 += 1
      else if (command(i) == 'R') x1 += 1
    })
    if (!func(command, x1, y1, x, y)) return false
    obstacles.indices.foreach(i => {
      val xObs = obstacles(i)(0)
      val yObs = obstacles(i)(1)
      if (xObs <= x && yObs <= y && func(command, x1, y1, xObs, yObs)) return false
    })
    true
  }

  def func(command: String, x1: Int, y1: Int, x: Int, y: Int): Boolean = {
    var x0 = 0
    var y0 = 0
    var k = 0
    if (x1 != 0 && y1 != 0) k = x / x1.min(y / y1)
    else if (x1 == 0) k = y / y1
    else if (y1 == 0) k = x / x1
    else return true
    command.indices.foreach(i => {
      if (x0 == x && y0 == y) return true
      if (command(i) == 'U') y0 += 1
      else x0 += 1
    })
    false
  }
}
