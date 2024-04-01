package leetCode._900

object Solution_853 {
  def carFleet(target: Int, positions: Array[Int], speeds: Array[Int]): Int = positions
    .map(_.toDouble)
    .zip(speeds)
    .sortBy { case (p, _) => -p }
    .foldLeft(0, 0.0) { case ((cnt, pre), (pos, speed)) =>
      val timeToTarget = (target - pos) / speed
      if (timeToTarget > pre) (cnt + 1, timeToTarget)
      else (cnt, pre)
    }
    ._1
}
