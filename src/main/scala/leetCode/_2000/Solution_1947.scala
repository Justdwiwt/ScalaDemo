package leetCode._2000

object Solution_1947 {
  def maxCompatibilitySum(students: Array[Array[Int]], mentors: Array[Array[Int]]): Int =
    f(students.toList, mentors.toSet)

  def f(students: List[Array[Int]], mentors: Set[Array[Int]]): Int = students match {
    case Nil => 0
    case s :: tail => mentors.map(m => g(s, m) + f(tail, mentors - m)).max
  }

  def g(s: Array[Int], m: Array[Int]): Int = s
    .zip(m)
    .count({ case (s, m) => s == m })
}
