package leetCode._1400

object Solution_1386 {
  def maxNumberOfFamilies(n: Int, reservedSeats: Array[Array[Int]]): Int = {
    val convertColToBitMap: Map[Int, Int] = Map(1 -> 0, 10 -> 0, 2 -> 4, 3 -> 4, 4 -> 6, 5 -> 6, 6 -> 3, 7 -> 3, 8 -> 1, 9 -> 1)
    val convertBitToSeatSubtract: Map[Int, Int] = Map(0 -> 0, 1 -> 1, 2 -> 0, 3 -> 1, 4 -> 1, 5 -> 1, 6 -> 1, 7 -> 2)
    val seatUnavailableCount = reservedSeats
      .groupBy(_.head)
      .map { case (_, v) =>
        val seatBitRepresentation = v.map(arr => convertColToBitMap(arr(1))).foldLeft(0)(_ | _)
        convertBitToSeatSubtract(seatBitRepresentation)
      }
      .sum
    2 * n - seatUnavailableCount
  }
}
