package leetCode._1500

object Solution_1451 {
  def arrangeWords(text: String): String = {
    text.toLowerCase.split(" ").sortBy(_.length).mkString(" ").capitalize
  }
}
