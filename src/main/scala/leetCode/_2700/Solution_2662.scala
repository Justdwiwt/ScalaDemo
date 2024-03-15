package leetCode._2700

import scala.collection.mutable

object Solution_2662 {
  def minimumCost(start: Array[Int], target: Array[Int], specialRoads: Array[Array[Int]]): Int = {
    val roads = specialRoads.filter { case Array(a, b, c, d, cost) => cost < (a - c).abs + (b - d).abs }
    val visited = mutable.Map((start.head, start(1)) -> 0)
    val toVisit = mutable.PriorityQueue((0, (start.head, start(1))))

    while (toVisit.nonEmpty) {
      val (totalCost, (x, y)) = toVisit.dequeue()
      roads.foreach { case Array(a, b, c, d, cost) =>
        if (visited.getOrElse((c, d), Int.MaxValue) > totalCost + cost + (x - a).abs + (y - b).abs)
          visited.update((c, d), totalCost + cost + (x - a).abs + (y - b).abs)
        toVisit.enqueue((visited((c, d)), (c, d)))
      }
    }

    roads.foldLeft((target.head - start.head).abs + (target(1) - start(1)).abs) {
      case (res, Array(_, _, c, d, _)) =>
        res.min(visited.getOrElse((c, d), Int.MaxValue) + (target.head - c).abs + (target(1) - d).abs)
    }
  }
}
