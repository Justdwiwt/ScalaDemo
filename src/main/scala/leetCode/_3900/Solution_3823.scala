package leetCode._3900

object Solution_3823 {
  def reverseByType(s: String): String =
    rev(s.filter(_.isLetter).reverse, s.filter(!_.isLetter).reverse, s.map(_.isLetter))

  @scala.annotation.tailrec
  private def rev(letters: String, symbols: String, letterSyms: Seq[Boolean], acc: String = ""): String =
    if (letterSyms.isEmpty) acc
    else if (letterSyms.head) rev(letters.tail, symbols, letterSyms.tail, acc :+ letters.head)
    else rev(letters, symbols.tail, letterSyms.tail, acc :+ symbols.head)
}
