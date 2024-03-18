package leetCode._2300

object Solution_2211 {
  def countCollisions(directions: String): Int = directions
    .dropWhile(_ == 'L')
    .reverse
    .dropWhile(_ == 'R')
    .count(_ != 'S')
}
