package leetCode._3400

object Solution_3330 {
  def possibleStringCount(word: String): Int =
    1 + word.zip(word.tail).count { case (x, y) => x == y }
}
