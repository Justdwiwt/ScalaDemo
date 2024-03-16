package leetCode._2500

import scala.collection.mutable

object Solution_2463 {
  def minimumTotalDistance(robot: List[Int], factory: Array[Array[Int]]): Long = {
    val robots = robot.sorted.map(_.toLong)
    val factories = factory.map { case Array(pos, limit) => (pos.toLong, limit) }.sorted
    val m = mutable.Map.empty[(Int, Int, Int), Long]

    def dfs(i: Int, j: Int, k: Int): Long = m.getOrElseUpdate((i, j, k),
      if (i == robots.length) 0
      else if (j == factories.length) Long.MaxValue / 100
      else factories(j) match {
        case (pos, limit) => if (limit <= k) dfs(i, j + 1, 0) else dfs(i, j + 1, 0).min(dfs(i + 1, j, k + 1) + (robots(i) - pos).abs)
      })

    dfs(0, 0, 0)
  }
}
