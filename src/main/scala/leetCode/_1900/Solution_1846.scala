package leetCode._1900

object Solution_1846 {
  def maximumElementAfterDecrementingAndRearranging(arr: Array[Int]): Int =
    arr.sorted.foldLeft(0)((acc, cur) => (acc + 1).min(cur))
}
