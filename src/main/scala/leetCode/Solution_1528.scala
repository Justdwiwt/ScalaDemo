package leetCode

object Solution_1528 {
  def restoreString(s: String, indices: Array[Int]): String = indices
    .zip(s)
    .sortBy(_._1)
    .map(_._2)
    .mkString
}
