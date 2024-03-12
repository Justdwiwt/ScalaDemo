package leetCode._1600

object Solution_1502 {
  def canMakeArithmeticProgression(arr: Array[Int]): Boolean = arr
    .indices
    .dropRight(1)
    .map({ i => val b = arr.sorted; (i, b) })
    .map({ case (i, b) => val s = b(i + 1) - b(i); (i, b, s) })
    .map({ case (_, _, s) => s })
    .toArray
    .toSet
    .size == 1
}
