package leetCode._3800

object Solution_3775 {
  private def vowels(s: String): Int = s.count {
    case 'a' | 'e' | 'i' | 'o' | 'u' => true
    case _ => false
  }

  def reverseWords(s: String): String = {
    val words = s.split(" ")
    val count = vowels(words.head)
    val rev = words
      .drop(1)
      .map(w => if (vowels(w) == count) w.reverse else w)
      .mkString(" ")
    (words.head + " " + rev).trim
  }
}
