package leetCode._1200

object Solution_1184 {
  def distanceBetweenBusStops(distance: Array[Int], start: Int, destination: Int): Int = {
    def f(from: Int, dest: Int): Int = {
      val total = distance.sum
      val fromToDist = distance.slice(from, dest).sum
      fromToDist.min(total - fromToDist)
    }

    f(start.min(destination), start.max(destination))
  }
}
