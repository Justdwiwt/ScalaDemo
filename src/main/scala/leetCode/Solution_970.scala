package leetCode

object Solution_970 {
  def f(x: Int, bound: Int): Int =
    if (x == 1) 0
    else math.floor(math.log(bound) / math.log(x)).toInt

  def powerfulIntegers(x: Int, y: Int, bound: Int): List[Int] = {
    (0 to f(x, bound)).flatMap(xExps => (0 to f(y, bound)).map(yExps => (math.pow(x, xExps) + math.pow(y, yExps)).toInt))
  }.toStream.filter(_ <= bound).distinct.toList
}
