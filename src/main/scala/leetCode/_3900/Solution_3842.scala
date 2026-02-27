package leetCode._3900

object Solution_3842 {
  def toggleLightBulbs(bulbs: List[Int]): List[Int] = bulbs
    .groupBy(identity)
    .toList
    .collect { case (v, list) if list.size % 2 == 1 => v }
    .sorted
}
