package leetCode._900

object Solution_874 {
  def robotSim(commands: Array[Int], obstacles: Array[Array[Int]]): Int = {
    val dx = Array(0, 1, 0, -1)
    val dy = Array(1, 0, -1, 0)
    var x = 0
    var y = 0
    var di = 0
    var res = 0

    val s = scala.collection.mutable.Set[(Int, Int)]()
    obstacles.indices.foreach(i => s += ((obstacles(i)(0), obstacles(i)(1))))
    commands.foreach({
      case -1 => di = (di + 1) % 4
      case -2 => di = (di - 1 + 4) % 4
      case cmd => (0 until cmd).foreach(_ => {
        val next = (x + dx(di), y + dy(di))
        if (!s.contains((x + dx(di), y + dy(di)))) {
          x = x + dx(di)
          y = y + dy(di)
          res = res.max(x * x + y * y)
        }
      })
    })
    res
  }
}
