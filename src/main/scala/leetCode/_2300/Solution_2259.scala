package leetCode._2300

object Solution_2259 {
  def removeDigit(number: String, digit: Char): String = {
    var res = ""
    number.indices.foreach(i => if (number(i) == digit) {
      val x = number.substring(0, i) + number.substring(i + 1)
      if (x.compareTo(res) > 0)
        res = x
    })
    res
  }
}
