package leetCode._2000

object Solution_1908 {
  def nimGame(piles: Array[Int]): Boolean =
    piles.foldLeft(0)(_ ^ _) != 0
}
