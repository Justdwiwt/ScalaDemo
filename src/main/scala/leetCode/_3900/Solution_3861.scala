package leetCode._3900

object Solution_3861 {
  def minimumIndex(capacity: Array[Int], itemSize: Int): Int = capacity
    .zipWithIndex
    .filter(_._1 >= itemSize)
    .sortBy(n => (n._1, n._2))
    .headOption
    .map(_._2)
    .getOrElse(-1)
}
