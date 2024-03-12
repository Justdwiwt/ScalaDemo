package leetCode._1800

object Solution_1717 {
  def maximumGain(s: String, x: Int, y: Int): Int = {
    if (x < y) return maximumGain(s.reverse, y, x)
    val r = s.indices./:(0, 0, 0)((res, i) => {
      if (s(i) == 'a') (res._1 + 1, res._2, res._3)
      else if (s(i) == 'b' && res._1 > 0) (res._1 - 1, res._2, res._3 + x)
      else if (s(i) == 'b') (res._1, res._2 + 1, res._3)
      else (0, 0, res._3 + res._1.min(res._2) * y)
    })
    r._3 + r._1.min(r._2) * y
  }
}
