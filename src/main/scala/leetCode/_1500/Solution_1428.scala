package leetCode._1500

object Solution_1428 {
  class BinaryMatrix {
    def get(row: Int, col: Int): Int = ???

    def dimensions(): Array[Int] = ???
  }

  def leftMostColumnWithOne(binaryMatrix: BinaryMatrix): Int = {
    val Array(rows, cols) = binaryMatrix.dimensions()

    def binarySearch(row: Int, left: Int, right: Int): Option[Int] =
      if (left > right) None
      else {
        val mid = left + (right - left) / 2
        binaryMatrix.get(row, mid) match {
          case 0 => binarySearch(row, mid + 1, right)
          case 1 => binarySearch(row, left, mid - 1).orElse(Some(mid))
        }
      }

    (0 until rows)
      .flatMap(binarySearch(_, 0, cols - 1))
      .reduceOption(_.min(_))
      .getOrElse(-1)
  }
}
