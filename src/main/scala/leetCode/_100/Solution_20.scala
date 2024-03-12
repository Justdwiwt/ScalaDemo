package leetCode._100

object Solution_20 {
  def isValid(s: String): Boolean = {
    val diff = Array("()", "[]", "{}")
    s./:(List.empty[Char]) { (a, v) =>
      a match {
        case x :: xs if diff.contains("" + x + v) => xs
        case _ => v +: a
      }
    }.isEmpty
  }
}
