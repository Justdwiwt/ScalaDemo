package leetCode._2000

object Solution_1901 {
  def findPeakGrid(mat: Array[Array[Int]]): Array[Int] =
    f(mat, 0, mat.length - 1)

  @scala.annotation.tailrec
  def f(mat: Array[Array[Int]], startRow: Int, endRow: Int): Array[Int] = {
    val midRow = (startRow + endRow) >>> 1
    var mx = 0
    mat.head.indices.drop(1).foreach(i => if (mat(midRow)(i) > mat(midRow)(mx)) mx = i)
    if (midRow == endRow) return Array(endRow, mx)
    if (mat(midRow)(mx) > mat(midRow + 1)(mx)) f(mat, startRow, midRow)
    else f(mat, midRow + 1, endRow)
  }
}
