package leetCode._2100

object Solution_2021 {
  def brightestPosition(lights: Array[Array[Int]]): Int = {
    val m = lights.flatMap { case Array(p, r) => (p - r, 1) :: (p + r + 1, -1) :: Nil }.groupBy(_._1).mapValues(_.map(_._2).sum)
    m.keys.toList.sorted.foldLeft((0, 0, 0)) {
      case ((d, mx, res), k) =>
        val updatedD = d + m(k)
        if (updatedD > mx) (updatedD, updatedD, k)
        else (updatedD, mx, res)
    }._3
  }
}
