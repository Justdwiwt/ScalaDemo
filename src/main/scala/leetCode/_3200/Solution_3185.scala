package leetCode._3200

object Solution_3185 {
  def countCompleteDayPairs(hours: Array[Int]): Long = hours
    .foldLeft((Map[Int, Int]().withDefaultValue(0), 0L)) { case ((map, ans), hour) =>
      val mod = hour % 24
      val complement = (24 - mod) % 24
      val updatedAns = ans + map(complement)
      val updatedMap = map.updated(mod, map(mod) + 1)
      (updatedMap, updatedAns)
    }
    ._2
}
