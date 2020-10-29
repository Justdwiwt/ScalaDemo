package leetCode

object Solution_302 {
  def minArea(image: Array[Array[Char]], x: Int, y: Int): Int = {
    var mnRow = Int.MaxValue
    var mnCol = Int.MaxValue
    var mxRow = Int.MinValue
    var mxCol = Int.MinValue
    image.indices.foreach(i => image.head.indices.foreach(j => if (image(i)(j) == '1') {
      mnRow = mnRow.min(i)
      mxRow = mxRow.max(i)
      mnCol = mnCol.min(j)
      mxCol = mxCol.max(j)
    }))
    (mxRow - mnRow + 1) * (mxCol - mnCol + 1)
  }
}
