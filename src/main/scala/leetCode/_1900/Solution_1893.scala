package leetCode._1900

object Solution_1893 {
  def isCovered(ranges: Array[Array[Int]], left: Int, right: Int): Boolean =
    (left to right).forall(x => ranges.exists(a => a.head <= x && a(1) >= x))
}
