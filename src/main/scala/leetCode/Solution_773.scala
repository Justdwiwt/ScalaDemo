package leetCode

import scala.collection.mutable
import scala.util.control.Breaks._

object Solution_773 {
  def slidingPuzzle(board: Array[Array[Int]]): Int = {
    var res = 0
    val target = "123450"
    var start = ""
    val dirs = Array(Array(1, 3), Array(0, 2, 4), Array(1, 5), Array(0, 4), Array(1, 3, 5), Array(2, 4))
    board.indices.foreach(i => board(0).indices.foreach(j => start += board(i)(j).toString))
    val visited = new mutable.HashSet[String]()
    start.foreach(i => visited.add(i.toString))
    val q = new mutable.Queue[String]()
    start.foreach(i => q.enqueue(i.toString))
    while (q.nonEmpty) {
      ((q.size - 1) to 0 by -1).foreach(i => {
        val cur = new mutable.StringBuilder()
        cur.append(q.front)
        q.dequeue
        if (cur.toString == target) return res
        val zero_idx = cur.indexOf("0")
        dirs(zero_idx).foreach(_ => {
          val cand = cur
          val t = cand(i)
          cand(i) = cand(zero_idx)
          cand(zero_idx) = t
          breakable {
            if (visited.contains(cand.toString)) break
          }
          visited.add(cand.toString)
          q.enqueue(cand.toString)
        })
      })
      res += 1
    }
    -1
  }
}
