package leetCode

object Solution_744 {
  def nextGreatestLetter(letters: Array[Char], target: Char): Char = {
    letters.filter(_ > target).sorted.headOption.getOrElse(letters.min)
  }
}
