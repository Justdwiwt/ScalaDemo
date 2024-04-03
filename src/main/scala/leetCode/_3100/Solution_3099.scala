package leetCode._3100

object Solution_3099 {
  def sumOfTheDigitsOfHarshadNumber(x: Int): Int =
    x.toString.map(_.asDigit).sum match {
      case sum if x % sum == 0 => sum
      case _ => -1
    }
}
