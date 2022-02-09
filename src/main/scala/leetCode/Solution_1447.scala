package leetCode

object Solution_1447 {
  def simplifiedFractions(n: Int): List[String] = (2 to n)
    .flatMap(x => (1 until x).map(n => (n / x.toFloat, n + "/" + x)))
    .groupBy(_._1)
    .values
    .map(_.head._2)
    .toList
}
