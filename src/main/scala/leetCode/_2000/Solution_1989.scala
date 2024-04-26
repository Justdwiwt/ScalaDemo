package leetCode._2000

object Solution_1989 {
  def catchMaximumAmountofPeople(team: Array[Int], dist: Int): Int = {
    val zeroIndices = team.zipWithIndex.collect { case (0, i) => i }
    val oneIndices = team.zipWithIndex.collect { case (1, i) => i }

    @scala.annotation.tailrec
    def f(queue: List[Int], ones: List[Int], res: Int): Int = ones match {
      case Nil => res
      case head :: tail =>
        val newQueue = queue.dropWhile(_ < head - dist)
        if (newQueue.nonEmpty && newQueue.head <= dist + head) f(newQueue.tail, tail, res + 1)
        else f(newQueue, tail, res)
    }

    f(zeroIndices.toList, oneIndices.toList, 0)
  }
}
