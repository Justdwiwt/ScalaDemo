package leetCode

object Solution_2126 {
  def asteroidsDestroyed(mass: Int, asteroids: Array[Int]): Boolean = asteroids
    .sorted
    ./:(mass.toLong)((m, a) => if (a > m) return false else m + a) > 0
}
