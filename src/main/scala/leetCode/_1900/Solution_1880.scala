package leetCode._1900

object Solution_1880 {
  def isSumEqual(firstWord: String, secondWord: String, targetWord: String): Boolean = {
    def f(s: String): Int = s.map(_ - 97)./:("")((b, a) => b ++ a.toString).toInt

    f(firstWord) + f(secondWord) == f(targetWord)
  }
}
