package leetCode._1600

object Solution_1502 {
  def canMakeArithmeticProgression(arr: Array[Int]): Boolean = arr
    .sorted
    .sliding(2)
    .map { case Array(prev, curr) => curr - prev }
    .toSet
    .size == 1
}
