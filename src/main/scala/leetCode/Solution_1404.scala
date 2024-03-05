package leetCode

object Solution_1404 {
  def numSteps(s: String): Int = {
    val res = (s.length - 1 to 1 by -1).foldLeft(0, 0)((acc, i) => if (s(i) - '0' + acc._2 == 1) (acc._1 + 2, 1) else (acc._1 + 1, acc._2))
    res._2 + res._1
  }
}
