package leetCode._2100

import scala.collection.mutable

object Solution_2056 {
  private val diff: Map[String, Array[(Int, Int)]] = Map(
    "rook" -> Array((0, 1), (0, -1), (1, 0), (-1, 0)),
    "bishop" -> Array((1, 1), (1, -1), (-1, 1), (-1, -1)),
    "queen" -> Array((0, 1), (0, -1), (1, 0), (-1, 0), (1, 1), (1, -1), (-1, 1), (-1, -1))
  )

  private def getMoves(p: String, x: Int, y: Int): Iterator[(Int, Int, Int, Int, Int)] = Iterator((x, y, 0, 0, 0)) ++ (1 to 7)
    .flatMap(t => diff(p).collect { case (dx, dy) if 1 <= x + dx * t && x + dx * t <= 8 && 1 <= y + dy * t && y + dy * t <= 8 => (x, y, dx, dy, t) })
    .iterator

  private def check(status: Array[(Int, Int, Int, Int, Int)]): Boolean = (0 until 8)
    .forall(t => {
      val seen = mutable.Set.empty[(Int, Int)]
      status.forall { case (x, y, dx, dy, pt) =>
        val dt = t.min(pt)
        val px = x + dx * dt
        val py = y + dy * dt
        if (seen.contains((px, py))) false
        else {
          seen.add((px, py))
          true
        }
      }
    })

  def countCombinations(pieces: Array[String], positions: Array[Array[Int]]): Int = {
    val statuses = pieces.zip(positions).map { case (p, Array(x, y)) => getMoves(p, x, y).toArray }
    val combinations = statuses.foldLeft(Iterator(Array.empty[(Int, Int, Int, Int, Int)])) {
      (acc, moves) => acc.flatMap(status => moves.map(status :+ _))
    }
    combinations.count(check)
  }
}
