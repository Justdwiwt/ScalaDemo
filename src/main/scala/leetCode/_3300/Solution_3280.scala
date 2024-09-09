package leetCode._3300

object Solution_3280 {
  def convertDateToBinary(date: String): String = date
    .split('-')
    .map(num => Integer.toBinaryString(num.toInt))
    .mkString("-")
}
