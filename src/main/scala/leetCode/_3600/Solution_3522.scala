package leetCode._3600

object Solution_3522 {
  def calculateScore(instructions: Array[String], values: Array[Int]): Long = {
    @scala.annotation.tailrec
    def f(i: Int, score: Long, visited: Set[Int]): Long =
      if (i < 0 || i >= values.length || visited.contains(i)) score
      else {
        val newVisited = visited + i
        instructions(i) match {
          case "add" => f(i + 1, score + values(i), newVisited)
          case _ => f(i + values(i), score, newVisited)
        }
      }

    f(0, 0L, Set.empty)
  }
}
