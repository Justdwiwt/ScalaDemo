package leetCode

object Solution_2410 {
  def matchPlayersAndTrainers(players: Array[Int], trainers: Array[Int]): Int = {
    val sortedP = players.sorted
    val sortedT = trainers.sorted

    @scala.annotation.tailrec
    def f(p: Int, t: Int, n: Int): Int =
      if (p >= sortedP.length || t >= sortedT.length) n
      else if (sortedP(p) > sortedT(t)) f(p, t + 1, n)
      else f(p + 1, t + 1, n + 1)

    f(0, 0, 0)
  }
}
