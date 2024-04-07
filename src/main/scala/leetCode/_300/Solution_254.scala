package leetCode._300

object Solution_254 {
  def getFactors(n: Int): List[List[Int]] = {
    def f(start: Int, num: Int): List[List[Int]] =
      if (num == 1) Nil
      else {
        val candidates = (start to math.sqrt(num).toInt).filter(num % _ == 0)
        candidates.flatMap(i => {
          val pair = List(i, num / i)
          val subFactors = f(i, num / i).map(i :: _)
          pair :: subFactors
        }).toList
      }

    f(2, n)
  }
}
