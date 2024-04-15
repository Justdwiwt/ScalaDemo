package leetCode._3200

object Solution_3114 {
  def findLatestTime(s: String): String =
    hours(s(0), s(1)) + ":" + third(s(3)) + fourth(s(4))

  private def hours(c1: Char, c2: Char): String =
    (c1, c2) match {
      case ('?', '?') => "11"
      case ('?', _) => if (c2 > '1') s"0$c2" else s"1$c2"
      case (_, '?') => if (c1 == '0') "09" else "11"
      case _ => c1.toString + c2
    }

  private def third(c: Char): Char =
    if (c == '?') '5' else c

  private def fourth(c: Char): Char =
    if (c == '?') '9' else c
}
