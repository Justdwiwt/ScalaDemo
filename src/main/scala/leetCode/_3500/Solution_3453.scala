package leetCode._3500

object Solution_3453 {
  def separateSquares(squares: Array[Array[Int]]): Double = {
    val M = 100000.0
    val (totArea, maxY) = squares.foldLeft((0.0, 0)) { case ((totalArea, maxY), sq) =>
      val area = sq(2).toLong * sq(2).toLong
      (totalArea + area, maxY.max(sq(1) + sq(2)))
    }

    @scala.annotation.tailrec
    def binarySearch(left: Long, right: Long): Long =
      if (left + 1 >= right) left
      else {
        val mid = (left + right) >>> 1
        if (check(squares, mid.toDouble / M, totArea)) binarySearch(left, mid)
        else binarySearch(mid, right)
      }

    val maxYLong = (maxY * M).toLong
    binarySearch(0L, maxYLong).toDouble / M
  }

  private def check(squares: Array[Array[Int]], y: Double, totArea: Double): Boolean = {
    val area = squares
      .filter(sq => sq(1) < y)
      .map(sq => sq(2) * math.min(y - sq(1), sq(2)))
      .sum
    area >= totArea / 2
  }
}
