package leetCode._500

import scala.collection.mutable

object Solution_403 {
  def canCross(stones: Array[Int]): Boolean = stones match {
    case Array(_) => true
    case Array(stone1, stone2, _*) if stone1 + 1 == stone2 =>
      val dp = mutable.Map[(Int, Int), Boolean]().withDefault(_._1 == stones.last)
      (stones.length - 2 to 1 by -1).foreach(i => (i + 1 until stones.length).foreach(j => {
        val distance = stones(j) - stones(i)
        (1.max(distance - 1) to (distance + 1).min(f(stones(i)).toInt)).foreach(dp(stones(i), _) |= dp(stones(j), distance))
      }))
      dp(stone2, 1)
    case _ => false
  }

  private def f(x: Int) =
    math.sqrt(2 * x + 0.25) - 0.5
}
