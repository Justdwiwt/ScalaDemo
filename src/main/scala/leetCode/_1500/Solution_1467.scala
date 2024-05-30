package leetCode._1500

object Solution_1467 {
  def getProbability(balls: Array[Int]): Double = {
    val sum = balls.sum
    val all = allCases(balls, 0, 0, 0, 0, 0, sum)
    val valid = casesWithEqualDistinctBalls(balls, 0, 0, 0, 0, 0, sum)
    valid / all
  }

  private def allCases(b: Array[Int], pos: Int, f: Int, s: Int, disF: Int, disS: Int, sum: Int): Double =
    if (pos == b.length) {
      if (f == s) fact(sum / 2) * fact(sum / 2)
      else 0
    } else {
      var res = allCases(b, pos + 1, f, s + b(pos), disF, disS + 1, sum) / fact(b(pos))
      res += allCases(b, pos + 1, f + b(pos), s, disF + 1, disS, sum) / fact(b(pos))
      (1 until b(pos)).foreach(i => res += allCases(b, pos + 1, f + i, s + b(pos) - i, disF + 1, disS + 1, sum) / (fact(i) * fact(b(pos) - i)))
      res
    }

  private def casesWithEqualDistinctBalls(b: Array[Int], pos: Int, f: Int, s: Int, disF: Int, disS: Int, sum: Int): Double =
    if (pos == b.length) {
      if (f == s && disF == disS) fact(sum / 2) * fact(sum / 2)
      else 0
    } else {
      var res = casesWithEqualDistinctBalls(b, pos + 1, f, s + b(pos), disF, disS + 1, sum) / fact(b(pos))
      res += casesWithEqualDistinctBalls(b, pos + 1, f + b(pos), s, disF + 1, disS, sum) / fact(b(pos))
      (1 until b(pos)).foreach(i => res += casesWithEqualDistinctBalls(b, pos + 1, f + i, s + b(pos) - i, disF + 1, disS + 1, sum) / (fact(i) * fact(b(pos) - i)))
      res
    }

  private def fact(n: Double): Double =
    (2 to n.toInt).foldLeft(1.0)(_ * _)
}
