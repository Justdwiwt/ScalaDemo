package leetCode._900

object Solution_871 {
  def minRefuelStops(target: Int, startFuel: Int, stations: Array[Array[Int]]): Int = stations
    ./:(Seq[Int](startFuel)) {
      case (dp, Array(pos, fuel)) => (0 +: dp :+ 0)
        .sliding(2)
        .map { case Seq(x, y) => y.max(if (x < pos) x else x + fuel) }
        .toSeq
    }
    .indexWhere(_ >= target)
}
