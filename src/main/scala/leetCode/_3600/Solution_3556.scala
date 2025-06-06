package leetCode._3600

object Solution_3556 {
  def sumOfLargestPrimes(s: String): Long = {
    val sorted = (1 to s.length)
      .flatMap(s.toCharArray.sliding(_).map(_.mkString.asNum).filter(_.isPrime))
      .toList
      .distinct
      .sorted
    (List(0L, 0L, 0L) ::: sorted).takeRight(3).sum
  }

  implicit class CharToNum(c: Char) {
    def asNum: Int = c - '0'
  }

  implicit class StringToNum(s: String) {
    def asNum: Long = s.toCharArray.foldLeft(0L) {
      case (num, value) => num * 10 + value.asNum
    }
  }

  implicit class IsPrime(num: Long) {
    def isPrime: Boolean = {
      if (num < 2 || (num > 2 && num % 2 == 0)) false
      else loop(2)
    }

    def loop(i: Long): Boolean = {
      if (i > math.sqrt(num.toDouble).toLong) true
      else if (num % i == 0) false
      else loop(i + 1)
    }
  }
}
