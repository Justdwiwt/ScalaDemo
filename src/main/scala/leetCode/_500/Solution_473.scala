package leetCode._500

object Solution_473 {
  def makesquare(matchsticks: Array[Int]): Boolean = {
    def f(remaining: Array[Int], target: Int): Boolean = remaining.isEmpty || (1 to remaining.length)
      .exists(remaining.combinations(_).exists(c => c.sum == target && f(remaining.diff(c), target)))

    matchsticks.length >= 4 && matchsticks.sum % 4 == 0 && f(matchsticks, matchsticks.sum / 4)
  }
}
