package leetCode

object Solution_1138 {
  def alphabetBoardPath(target: String): String = {
    def f(s: Char, t: Char): String = (g(s), g(t)) match {
      case ((x1, y1), (x2, y2)) =>
        var res = ""
        if (y1 > y2) res += "L" * (y1 - y2)
        if (y1 < y2) res += "R" * (y2 - y1)
        if (x1 > x2) res += "U" * (x1 - x2)
        if (x1 < x2) res += "D" * (x2 - x1)
        if (s == 'z') res.reverse + "!" else res + "!"
    }

    def g(ch: Char): (Int, Int) = ((ch - 'a') / 5, (ch - 'a') % 5)

    ("a" + target).zip(target).map({ case (s, t) => f(s, t) }).reduce(_ + _)
  }
}
