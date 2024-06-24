package leetCode._3200

object Solution_3195 {
  def minimumArea(grid: Array[Array[Int]]): Int = {
    val allOnes = grid
      .zipWithIndex
      .flatMap { case (row, i) => row
        .zipWithIndex
        .withFilter { case (value, _) => value == 1 }
        .map { case (_, j) => (i, j) }
      }

    val (top, bottom, left, right) = allOnes.foldLeft((Int.MaxValue, 0, Int.MaxValue, 0)) {
      case ((topAcc, bottomAcc, leftAcc, rightAcc), (i, j)) =>
        (topAcc.min(i), bottomAcc.max(i), leftAcc.min(j), rightAcc.max(j))
    }

    val width = right - left + 1
    val height = bottom - top + 1
    width * height
  }
}
