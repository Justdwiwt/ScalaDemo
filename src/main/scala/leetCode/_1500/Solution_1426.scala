package leetCode._1500

object Solution_1426 {
  def countElements(arr: Array[Int]): Int = arr
    .zipWithIndex
    .count { case (e, _) => arr.contains(e + 1) }
}
