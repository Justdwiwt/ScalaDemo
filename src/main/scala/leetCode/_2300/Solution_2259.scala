package leetCode._2300

object Solution_2259 {
  def removeDigit(number: String, digit: Char): String = {
    val indices = number.indices.filter(number(_) == digit)

    val drop = if (indices.length == 1) indices.head
    else indices
      .filterNot(_ == number.length - 1)
      .find(i => number(i) < number(i + 1))
      .getOrElse(indices.last)

    number.substring(0, drop) ++ number.substring(drop + 1)
  }
}
