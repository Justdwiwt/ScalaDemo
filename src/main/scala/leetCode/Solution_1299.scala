package leetCode

object Solution_1299 {
  def replaceElements(arr: Array[Int]): Array[Int] = arr
    .tail
    .scanRight(-1)(_.max(_))
}
