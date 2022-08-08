package leetCode

object Solution_2358 {
  def maximumGroups(grades: Array[Int]): Int =
    (math.sqrt(grades.length * 2 + 0.25) - 0.5).toInt
}
