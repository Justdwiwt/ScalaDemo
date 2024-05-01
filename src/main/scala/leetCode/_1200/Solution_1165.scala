package leetCode._1200

object Solution_1165 {
  def calculateTime(keyboard: String, word: String): Int = {
    val m = keyboard.zipWithIndex.toMap
    word.foldLeft((0, 0)) { case ((totalTime, prevIndex), char) =>
      val currentIndex = m(char)
      (totalTime + (currentIndex - prevIndex).abs, currentIndex)
    }._1
  }
}
