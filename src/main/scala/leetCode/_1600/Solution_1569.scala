package leetCode._1600

import scala.collection.immutable.NumericRange
import scala.util.Try

object Solution_1569 {

  class ModularNumeric(k: BigInt) extends Numeric[BigInt] {
    assert(k > 0)

    override def plus(x: BigInt, y: BigInt): BigInt = abs(x + y)

    override def minus(x: BigInt, y: BigInt): BigInt = abs(x - y)

    override def times(x: BigInt, y: BigInt): BigInt = abs(x * y)

    override def negate(x: BigInt): BigInt = abs(-x)

    override def fromInt(x: Int): BigInt = abs(BigInt(x))

    def parseString(str: String): Option[BigInt] = Try(BigInt(str)).map(abs).toOption

    override def toInt(x: BigInt): Int = abs(x).toInt

    override def toLong(x: BigInt): Long = abs(x).toLong

    override def toFloat(x: BigInt): Float = abs(x).toFloat

    override def toDouble(x: BigInt): Double = abs(x).toDouble

    override def compare(x: BigInt, y: BigInt): Int = abs(x).compare(abs(y))

    override def one: BigInt = abs(super.one)

    override def abs(x: BigInt): BigInt = (x % k + k) % k

    def sign(x: BigInt): BigInt = abs(x)

    def factorial(x: BigInt): BigInt = abs(NumericRange.inclusive(BigInt(2), x, BigInt(1)).product)
  }

  class ModularFractional(k: BigInt) extends ModularNumeric(k) with Fractional[BigInt] {
    assert(ModularFractional.isPrime(k))

    override def div(x: BigInt, y: BigInt): BigInt = times(x, y.modInverse(k))

    def choose(x: BigInt, y: BigInt): BigInt = div(div(factorial(x), factorial(y)), factorial(x - y))
  }

  object ModularFractional {
    private def isPrime(x: BigInt) = NumericRange
      .inclusive(BigInt(2), x, BigInt(1))
      .takeWhile(y => y * y <= x)
      .forall(x % _ != 0)
  }

  private val Fractional = new ModularFractional(1000000007)

  def numOfWays(nums: Array[Int]): Int = {
    def f(nums: Seq[Int]): BigInt = nums match {
      case Seq(head, tail@_*) => tail.partition(_ < head) match {
        case (left, right) => Seq(Fractional.choose(tail.size, left.size), f(left), f(right)).reduce(Fractional.times)
      }
      case _ => 1
    }

    Fractional.minus(f(nums), 1).toInt
  }
}
