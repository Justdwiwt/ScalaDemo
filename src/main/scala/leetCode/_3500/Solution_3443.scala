package leetCode._3500

object Solution_3443 {
  def maxDistance(s: String, k: Int): Int = {
    var res = 0
    var x = 0
    var y = 0

    s.zipWithIndex.foreach { case (c, i) =>
      c match {
        case 'N' => y += 1
        case 'S' => y -= 1
        case 'E' => x += 1
        case 'W' => x -= 1
        case _ =>
      }
      res = res.max((i + 1).min(x.abs + y.abs + k * 2))
    }

    res
  }
}
