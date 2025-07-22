package leetCode._3600

object Solution_3582 {
  def generateTag(caption: String): String = {
    val words = caption.trim.split("\\s+").filter(_.nonEmpty)
    if (words.isEmpty) "#"
    else {
      val tag = words.head.toLowerCase + words.tail.map(_.toLowerCase.capitalize).mkString
      "#" + tag.take(99)
    }
  }
}
