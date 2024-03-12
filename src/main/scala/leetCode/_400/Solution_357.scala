package leetCode._400

object Solution_357 {
  def countNumbersWithUniqueDigits(n: Int): Int =
    (10 until 10 - 9.min(n) by -1)./:((1, 1)) { case ((res, pre), x) =>
      (res + pre * x.min(9), pre * x.min(9))
    }._1
}
