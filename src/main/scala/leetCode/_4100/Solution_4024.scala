package leetCode._4100

object Solution_4024 {
  def nearestDrone(drones: Array[Array[Int]], target: Array[Int]): Int = {
    val Array(tx, ty) = target

    drones
      .zipWithIndex
      .filter { case (Array(x, y, r), _) => (x - tx).abs + (y - ty).abs <= r }
      .map { case (Array(x, y, _), i) => ((x - tx).abs + (y - ty).abs, i) }
      .sortBy(identity)
      .headOption
      .fold(-1)(_._2)
  }
}
