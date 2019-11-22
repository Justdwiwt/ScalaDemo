package leetCode

object Solution_168 {
  @scala.annotation.tailrec
  def convertToTitle(n: Int, acc: String = ""): String = n match {
    case x if x <= 0 => ""
    case x if x <= 26 => ('A' + n - 1).toChar + acc
    case x if x % 26 == 0 => convertToTitle(n / 26 - 1, ('A' + (n - 1) % 26).toChar + acc)
    case _ => convertToTitle(n / 26, ('A' + (n - 1) % 26).toChar + acc)
  }
}
