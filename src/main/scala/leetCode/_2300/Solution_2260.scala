package leetCode._2300

object Solution_2260 {
  def minimumCardPickup(cards: Array[Int]): Int = {
    val (_, min) = cards.zipWithIndex./:(Map.empty[Int, Int], Int.MaxValue) { case ((map, min), (card, idx)) =>
      if (map.contains(card)) (map + (card -> idx), min.min(idx - map(card) + 1))
      else (map + (card -> idx), min)
    }
    if (min == Int.MaxValue) -1 else min
  }
}
