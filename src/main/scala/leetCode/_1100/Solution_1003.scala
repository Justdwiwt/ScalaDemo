package leetCode._1100

object Solution_1003 {
  @scala.annotation.tailrec
  def isValid(S: String): Boolean = S.isEmpty || (S.contains("abc") && isValid(S.replaceAll("abc", "")))
}
