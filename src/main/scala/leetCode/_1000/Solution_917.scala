package leetCode._1000

object Solution_917 {
  def reverseOnlyLetters(S: String): String = {
    val letters = S.filter(_.isLetter).reverseIterator
    S.map(m => if (m.isLetter) letters.next else m)
  }
}
