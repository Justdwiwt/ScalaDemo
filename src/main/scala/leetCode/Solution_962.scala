package leetCode

object Solution_962 {
  def maxWidthRamp(A: Array[Int]): Int = {
    val sorted = A.indices.map(i => (A(i), i)).sortWith(_._1 < _._1).map(_._2)
    sorted.tail./:(sorted.head, 0) { case ((mnIdx, res), idx) =>
      val width = idx - mnIdx
      val newIdx = if (idx < mnIdx) idx else mnIdx
      if (width > 0 && width > res) (newIdx, width)
      else (newIdx, res)
    }._2
  }
}
