package leetCode._2200

object Solution_2126 {
  def asteroidsDestroyed(mass: Int, asteroids: Array[Int]): Boolean = asteroids
    .sorted
    .foldLeft(Option(mass.toLong)) {
      case (Some(m), a) if a <= m => Some(m + a)
      case _ => None
    }
    .isDefined
}
