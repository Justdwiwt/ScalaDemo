package leetCode._300

object Solution_279 {
  def numSquares(n: Int): Int = {
    def memoize[I, O](f: I => O): I => O = new scala.collection.mutable.HashMap[I, O]() {
      override def apply(key: I): O = getOrElseUpdate(key, f(key))
    }

    lazy val numSq: Int => Int = memoize {
      case 0 => 0
      case x => Range(math.sqrt(x).toInt, 1, -1).foldLeft(x)((a, b) => a.min(numSq(x - b * b) + 1))
    }
    numSq(n)
  }
}
