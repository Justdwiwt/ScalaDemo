package leetCode

object Solution_2000 {
  def reversePrefix(word: String, ch: Char): String = word.indexOf(ch) match {
    case -1 => word
    case i => word.substring(0, i + 1).reverse + word.substring(i + 1)
  }
}
