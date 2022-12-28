package leetCode

object Solution_2515 {
  def closetTarget(words: Array[String], target: String, startIndex: Int): Int = {
    def f(i: Int): String = words((words.length + startIndex + i) % words.length)

    words.indices.find(i => f(-i) == target || f(i) == target).getOrElse(-1)
  }
}
