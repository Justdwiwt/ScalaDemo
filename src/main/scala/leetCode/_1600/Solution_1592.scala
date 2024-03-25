package leetCode._1600

object Solution_1592 {
  def reorderSpaces(text: String): String = {
    val spaces = text.count(_ == ' ')
    val words = text.split(" ").collect { case w if w.trim.nonEmpty => w.trim }
    if (words.length == 0) return " " * spaces
    if (words.length == 1) return words.head + " " * spaces
    val spacesBetweenWords = " " * (spaces / (words.length - 1))
    val spacesAtEnd = " " * (spaces % (words.length - 1))
    words.mkString(spacesBetweenWords) + spacesAtEnd
  }
}
