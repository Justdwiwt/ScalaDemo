package leetCode

object Solution_1432 {
  def maxDiff(num: Int): Int = {
    val digits = num.toString
    val max = digits.find(_ != '9').fold(digits)(d => digits.replaceAll(d.toString, "9"))
    val min = digits.head match {
      case '1' => digits.find(_ > '1').fold(digits)(d => digits.replaceAll(d.toString, "0"))
      case d => digits.replaceAll(d.toString, "1")
    }
    max.toInt - min.toInt
  }
}
