package leetCode._3300

object Solution_3259 {
  def maxEnergyBoost(energyDrinkA: Array[Int], energyDrinkB: Array[Int]): Long =
    f(energyDrinkA.zip(energyDrinkB).toList, 0, 0, 0, 0)

  @scala.annotation.tailrec
  private def f(drinks: List[(Int, Int)], a2: Long, a1: Long, b2: Long, b1: Long): Long = drinks match {
    case Nil => a1.max(b1)
    case (a, b) :: tail => f(tail, a1, a1.max(b2) + a, b1, b1.max(a2) + b)
  }
}
