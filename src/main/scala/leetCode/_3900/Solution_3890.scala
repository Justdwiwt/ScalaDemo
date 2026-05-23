package leetCode._3900

object Solution_3890 {
  private val MX = 1000000000

  private val goodIntegers: List[Int] = {
    val cnt = Iterator
      .from(1)
      .takeWhile(a => a.toLong * a * a * 2 <= MX)
      .flatMap(a => Iterator
        .from(a)
        .map(b => a.toLong * a * a + b.toLong * b * b)
        .takeWhile(_ <= MX)
        .map(_.toInt))
      .toList
      .groupBy(identity)
      .collect {
        case (x, xs) if xs.length > 1 => x
      }
      .toList
      .sorted

    cnt
  }

  def findGoodIntegers(n: Int): List[Int] =
    goodIntegers.takeWhile(_ <= n)
}
