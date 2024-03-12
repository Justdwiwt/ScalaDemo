package leetCode._1300

object Solution_1299 {
  def replaceElements(arr: Array[Int]): Array[Int] = arr
    .tail
    .scanRight(-1)(_.max(_))
}
