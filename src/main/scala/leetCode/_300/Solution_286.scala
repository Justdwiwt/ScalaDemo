package leetCode._300

import scala.collection.mutable

object Solution_286 {
  private val EMPTY = Int.MaxValue
  private val GATE = 0
  private val DIRECTIONS = List((1, 0), (-1, 0), (0, 1), (0, -1))

  def wallsAndGates(rooms: Array[Array[Int]]): Unit = {
    val (m, n) = (rooms.length, rooms.headOption.map(_.length).getOrElse(0))

    def isValid(r: Int, c: Int): Boolean =
      r >= 0 && c >= 0 && r < m && c < n

    def bfs(q: mutable.Queue[(Int, Int)]): Unit = {
      while (q.nonEmpty) {
        val (row, col) = q.dequeue()
        val distance = rooms(row)(col)
        DIRECTIONS.foreach { case (dr, dc) =>
          val (r, c) = (row + dr, col + dc)
          if (isValid(r, c) && rooms(r)(c) == EMPTY) {
            rooms(r)(c) = distance + 1
            q.enqueue((r, c))
          }
        }
      }
    }

    val q = mutable.Queue.empty[(Int, Int)]
    rooms.indices.foreach(row => (0 until n).withFilter(rooms(row)(_) == GATE).foreach(col => q.enqueue((row, col))))

    bfs(q)
  }
}
