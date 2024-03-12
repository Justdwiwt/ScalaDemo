package leetCode._1000

import scala.collection.mutable

object Solution_909 {
  def snakesAndLadders(board: Array[Array[Int]]): Int = {
    val flatBoard = board
      .reverse
      .zipWithIndex
      .flatMap({ case (a, i) => if (i % 2 == 1) a.reverse else a })
    val pq = mutable.PriorityQueue[(Int, Int)]()(Ordering.by(-_._2))
    pq += ((0, 0))
    val visited = mutable.BitSet()
    val dest = board.length * board.length - 1
    while (pq.nonEmpty) {
      val t = pq.dequeue()
      visited += t._1
      if (t._1 == dest) return t._2
      pq ++= (1 to 6)
        .map(_ + t._1)
        .collect({
          case x if x <= dest =>
            val lkp = flatBoard(x)
            if (lkp != -1) lkp - 1 else x
        })
        .collect({ case x if !visited.contains(x) => (x, t._2 + 1) })
        .toSet
    }
    -1
  }
}
