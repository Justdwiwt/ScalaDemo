package leetCode._2200

object Solution_2139 {
  def minMoves(target: Int, maxDoubles: Int): Int = {
    @scala.annotation.tailrec
    def f(n: Int, doubles: Int, moves: Int): Int =
      if (n == 1) moves
      else if (doubles == maxDoubles) moves + n - 1
      else if (n % 2 == 1) f(n - 1, doubles, moves + 1)
      else f(n / 2, doubles + 1, moves + 1)

    f(n = target, doubles = 0, moves = 0)
  }
}
