package leetCode._2800

object Solution_2710 {
  def removeTrailingZeros(num: String): String = num
    .reverse
    .dropWhile(_ == '0')
    .reverse
}
