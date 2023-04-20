package leetCode

object Solution_2514 {
  val M = 1000000007

  private trait Arithmetic[T] {
    def factorial(n: Int): T

    def multiply(a: T, b: T): T

    def division(a: T, b: T): T

    def toInt(n: T): Int
  }


  private def doCount[T](s: String, ar: Arithmetic[T]): Int = {
    val wordCounts = s.split(' ').toList.map(word => {
      val charCounts = word.groupBy(identity).map(pair => ar.factorial(pair._2.length))
      ar.division(ar.factorial(word.length()), charCounts.reduce(ar.multiply))
    })
    ar.toInt(wordCounts.reduce(ar.multiply))
  }

  private final class IntModuloArithmetic(mInt: Int) extends Arithmetic[Int] {
    private val m = BigInt(mInt)

    def factorial(n: Int): Int =
      (2 to n)./:(1)((acc, el) => multiply(acc, el))

    def multiply(a: Int, b: Int): Int =
      (BigInt(a) * BigInt(b)).mod(m).toInt

    def division(a: Int, b: Int): Int =
      (BigInt(b).modInverse(m) * a).mod(m).toInt

    def toInt(n: Int): Int = n
  }

  def countAnagrams(s: String): Int =
    doCount(s, new IntModuloArithmetic(M))
}
