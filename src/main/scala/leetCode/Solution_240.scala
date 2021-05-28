package leetCode

object Solution_240 {
  def searchMatrix(matrix: Array[Array[Int]], target: Int): Boolean = {
    @scala.annotation.tailrec
    def f(row: Int, col: Int): Boolean =
      if (row >= matrix.length || col < 0) false
      else matrix(row)(col).compareTo(target) match {
        case 0 => true
        case 1 => f(row, col - 1)
        case -1 => f(row + 1, col)
      }

    if (matrix.isEmpty) false
    else f(0, matrix.head.length - 1)
  }
}
