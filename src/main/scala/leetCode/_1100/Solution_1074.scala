package leetCode._1100

object Solution_1074 {
  def numSubmatrixSumTarget(matrix: Array[Array[Int]], target: Int): Int = {
    val numRows = matrix.length
    val numCols = matrix.headOption.map(_.length).getOrElse(0)
    val rowCumSums = matrix.map(_.scan(0)(_ + _))

    val colCumSums = (0 until numCols).map(j => matrix.indices.scanLeft(0) { case (cumSum, i) => cumSum + matrix(i)(j) })

    (1 to numRows)
      .iterator
      .flatMap(height => (1 to numCols).iterator.map(height -> _))
      .flatMap { case (height, width) => (0 until numRows - height)
        .iterator
        .scanLeft(rowCumSums.iterator.take(height).map(_(width)).sum) {
          case (slidingSum, i) => slidingSum + rowCumSums(i + height)(width) - rowCumSums(i)(width)
        }
        .zipWithIndex
        .flatMap { case (sum, i) =>
          (0 until numCols - width)
            .iterator
            .scanLeft(sum) { case (slidingSum, j) => slidingSum +
              (colCumSums(j + width)(i + height) - colCumSums(j + width)(i)) -
              (colCumSums(j)(i + height) - colCumSums(j)(i))
            }
        }
      }
      .count(_ == target)
  }
}
