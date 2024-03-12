package leetCode._900

object Solution_898 {
  def subarrayBitwiseORs(arr: Array[Int]): Int = arr
    .scanLeft(Array.empty[Int])((pre, n) => (pre :+ 0).map(_ | n).distinct)
    .flatten
    .distinct
    .length
}
