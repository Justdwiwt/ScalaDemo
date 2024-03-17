package leetCode._2400

object Solution_2358 {
  def maximumGroups(grades: Array[Int]): Int = Iterator
    .iterate((0, 0)) { case (total, k) => (total + (k + 1), k + 1) }
    .dropWhile { case (total, k) => (total + k + 1) <= grades.length }
    .next()
    ._2
}
