package leetCode

import scala.collection.immutable

object Solution_365 {
  def canMeasureWater(bucket1: Int, bucket2: Int, measure: Int): Boolean = {
    @scala.annotation.tailrec
    def f(visited: immutable.HashSet[(Int, Int)], queue: immutable.Queue[(Int, Int, Int)]): Boolean = queue.headOption match {
      case Some((capacity1: Int, capacity2: Int, numberOfMoves: Int)) =>
        if (capacity1 == measure || capacity2 == measure || capacity1 + capacity2 == measure) true
        else if (visited.contains((capacity1, capacity2))) f(visited, queue.tail)
        else {
          val transfer1 = math.min(capacity2, bucket1 - capacity1)
          val transfer2 = math.min(capacity1, bucket2 - capacity2)

          f(
            visited = visited + ((capacity1, capacity2)),
            queue = queue.tail.enqueue(List(
              (bucket1, capacity2, numberOfMoves + 1),
              (capacity1, bucket2, numberOfMoves + 1),
              (capacity1 + transfer1, capacity2 - transfer1, numberOfMoves + 1),
              (capacity1 - transfer2, capacity2 + transfer2, numberOfMoves + 1),
              (0, capacity2, numberOfMoves + 1),
              (capacity1, 0, numberOfMoves + 1)
            ))
          )
        }
      case None => false
    }

    f(immutable.HashSet.empty, immutable.Queue[(Int, Int, Int)]((0, 0, 0)))
  }
}
