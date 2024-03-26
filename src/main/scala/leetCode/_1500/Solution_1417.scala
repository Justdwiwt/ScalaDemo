package leetCode._1500

object Solution_1417 {
  def reformat(s: String): String = {
    val digits = s.filter(_.isDigit)
    val chars = s.filter(_.isLetter)

    (digits.length, chars.length) match {
      case (x, y) if (x - y).abs > 1 => ""
      case (x, y) if x - y == 1 => digits.zip(chars).flatten(f => f._1.toString ++ f._2.toString).mkString("") ++ digits.last.toString
      case (x, y) if y - x == 1 => chars.zip(digits).flatten(f => f._1.toString ++ f._2.toString).mkString("") ++ chars.last.toString
      case _ => chars.zip(digits).flatten(f => f._1.toString ++ f._2.toString).mkString("")
    }
  }
}
