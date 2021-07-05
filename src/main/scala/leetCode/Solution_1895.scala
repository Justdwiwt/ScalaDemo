package leetCode

object Solution_1895 {
  def largestMagicSquare(grid: Array[Array[Int]]): Int = {
    val rowSum = grid.map(row => row.scanLeft(0)(_ + _))
    val colSum = grid.transpose.map(_.scanLeft(0)(_ + _)).transpose
    var res = 1
    grid.indices.foreach(r => grid.head.indices.foreach(c => (2 until grid.length.min(grid.head.length) + 1).foreach(size =>
      if ((size + r - 1) < grid.length && (size + c - 1) < grid.head.length) {
        val rowsVal = Range(r, r + size).map(dr => rowSum(dr)(c + size) - rowSum(dr)(c))
        val colsVal = Range(c, c + size).map(dc => colSum(r + size)(dc) - colSum(r)(dc))
        var d1 = 0
        (0 until size).foreach(k => d1 += grid(r + k)(c + k))
        var d2 = 0
        (0 until size).foreach(k => d2 += grid(r + k)(size - k + c - 1))
        if (d1 == d2 && rowsVal.toSet.size == 1 && colsVal.toSet.size == 1 && rowsVal.head == colsVal.head && rowsVal.head == d1)
          res = res.max(size)
      })))
    res
  }
}
