package leetCode._200

import scala.math.Integral.Implicits._
import scala.math._

object Solution_166 {
  def fractionToDecimal(numerator: Int, denominator: Int): String = {
    val sign = if (signum(numerator) * signum(denominator) == -1) "-" else ""
    sign + fractionToDecimal(abs(numerator.toLong), abs(denominator.toLong))
  }

  private def fractionToDecimal(numerator: Long, denominator: Long): String = numerator./%(denominator) match {
    case (quot, 0) => quot.toString
    case (quot, rem) => quot.toString + "." + generateFractional(rem, denominator)
  }

  @scala.annotation.tailrec
  private def generateFractional(numerator: Long, denominator: Long, numeratorToIdx: Map[Long, Int] = Map(), fractional: String = ""): String = numeratorToIdx.get(numerator) match {
    case Some(index) => fractional.substring(0, index) + "(" + fractional.substring(index) + ")"
    case _ => (10 * numerator)./%(denominator) match {
      case (quot, 0) => fractional + quot
      case (quot, rem) => generateFractional(rem, denominator, numeratorToIdx + (numerator -> fractional.length), fractional + quot)
    }
  }
}
