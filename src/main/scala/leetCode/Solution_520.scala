package leetCode

object Solution_520 {
  def detectCapitalUse(word: String): Boolean = word.tail.forall(_.isLower) || word.forall(_.isUpper)
}
