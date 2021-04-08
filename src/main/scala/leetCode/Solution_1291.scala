package leetCode

object Solution_1291 {
  def sequentialDigits(low: Int, high: Int): List[Int] = {
    def getInit(n: Int): Int = 1.to(n).reduce(_ * 10 + _)

    def getInc(n: Int): Int = List.fill(n)(1).reduce(_ * 10 + _)

    def digitNum(x: Int): Int = x.toString.length

    def getNext(x: Int): Int = if (x % 10 < 9) x + getInc(digitNum(x)) else getInit(digitNum(x) + 1)

    val res = getInit(digitNum(low))

    def worker(x: Int): Stream[Int] = x #:: worker(getNext(x))

    worker(res).dropWhile(_ < low).takeWhile(_ <= high).toList
  }
}
