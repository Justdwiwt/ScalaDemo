package leetCode._1100

object Solution_1020 {
  var m: Array[Boolean] = _
  var height = 0
  var width = 0

  def numEnclaves(A: Array[Array[Int]]): Int = {
    m = null
    height = A.length
    width = A(0).length

    m = Array.fill(height * width)(false)

    val arr = A.flatten

    (0 until width).foreach(i => {
      traverse(arr, 0, i)
      traverse(arr, height - 1, i)
    })

    (0 until height).foreach(i => {
      traverse(arr, i, 0)
      traverse(arr, i, width - 1)
    })

    arr.count(_.equals(1))
  }

  def traverse(arr: Array[Int], nRow: Int, nCol: Int): Unit = {
    if (nRow > height - 1 || nRow < 0 || nCol > width - 1 || nCol < 0) {}
    else {
      val idx = nRow * width + nCol
      if (arr(idx) != 0 && !m(idx)) {
        arr.update(idx, 0)
        m.update(idx, true)
        traverse(arr, nRow + 1, nCol)
        traverse(arr, nRow - 1, nCol)
        traverse(arr, nRow, nCol + 1)
        traverse(arr, nRow, nCol - 1)
      }
    }
  }
}
