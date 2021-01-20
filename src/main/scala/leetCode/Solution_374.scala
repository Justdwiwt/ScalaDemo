package leetCode

class GuessGame {
  def guess(num: Int): Int = ???
}

object Solution_374 extends GuessGame {
  def guessNumber(n: Int): Int = {
    @scala.annotation.tailrec
    def f(l: Int, r: Int, cur: Int): Int = guess(cur) match {
      case -1 => f(l, cur, l + (cur - l) / 2)
      case 1 => f(cur, r, r + (cur - r) / 2)
      case 0 => cur
    }

    f(1, n, 1)
  }
}
