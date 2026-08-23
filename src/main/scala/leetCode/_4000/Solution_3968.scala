package leetCode._4000

object Solution_3968 {
  def maxDistance(moves: String): Int =
    (moves.count(_ == 'U') - moves.count(_ == 'D')).abs +
      (moves.count(_ == 'R') - moves.count(_ == 'L')).abs +
      moves.count(_ == '_')
}
