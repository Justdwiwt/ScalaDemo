package leetCode._2200

import leetCode.Common.neighbours

import scala.collection.mutable

object Solution_2146 {
  def highestRankedKItems(grid: Array[Array[Int]], pricing: Array[Int], start: Array[Int], k: Int): List[List[Int]] = {
    val toVisit = mutable.Queue((start.head, start.last, 0))
    val visited = mutable.Set((start.head, start.last))
    val items = mutable.ListBuffer.empty[(Int, Int, Int, Int)]

    while (toVisit.nonEmpty) {
      val (x, y, distance) = toVisit.dequeue
      if (grid(x)(y) >= pricing.head && grid(x)(y) <= pricing.last) items.append((distance, grid(x)(y), x, y))
      neighbours(x, y, grid).foreach { case (nx, ny) =>
        if (!visited.contains((nx, ny)) && grid(nx)(ny) != 0) visited.add((nx, ny))
        toVisit.enqueue((nx, ny, distance + 1))
      }
    }
    items.sorted.take(k).map { case (_, _, x, y) => List(x, y) }.toList
  }
}
