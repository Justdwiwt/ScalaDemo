package leetCode._3200

object Solution_3184 {
  def countCompleteDayPairs(hours: Array[Int]): Int = hours
    .foldLeft((0, Map[Int, Int]().withDefaultValue(0))) { case ((ans, g), x) =>
      val cur = x % 24
      val newAns = ans + g(cur)
      val newG = g.updated((24 - cur) % 24, g((24 - cur) % 24) + 1)
      (newAns, newG)
    }
    ._1
}
