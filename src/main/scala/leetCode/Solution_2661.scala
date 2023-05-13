package leetCode

object Solution_2661 {
  def firstCompleteIndex(arr: Array[Int], mat: Array[Array[Int]]): Int = {
    val indexMap = mat.indices./:(Map.empty[Int, (Int, Int)])((idx, r) => mat.head.indices./:(idx)((i, c) => i.updated(mat(r)(c), (r, c))))
    arr.indices./:(Map.empty[Int, Int], Map.empty[Int, Int]) { case ((row, col), i) =>
      val (r, c) = indexMap(arr(i))
      val newRowCount = row.updated(r, row.getOrElse(r, 0) + 1)
      val newColCount = col.updated(c, col.getOrElse(c, 0) + 1)
      if (newRowCount(r) == mat.head.length || newColCount(c) == mat.length) return i
      (newRowCount, newColCount)
    }
    -1
  }
}
