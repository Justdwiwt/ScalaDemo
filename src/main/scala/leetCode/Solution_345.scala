package leetCode

object Solution_345 {
  def reverseVowels(s: String): String = {
    val vowels = "(?i)[aeiou]".r
    val reversed = vowels.findAllIn(s).toList.reverse
    val (result, _) = s./:(new StringBuilder(), reversed) { case ((acc, rev), curr) =>
      if (vowels.toString.matches(curr.toString)) (acc ++= rev.head, rev.tail)
      else (acc += curr, rev)
    }
    result.toString
  }
}
