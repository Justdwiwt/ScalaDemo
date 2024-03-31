package leetCode._1000

object Solution_976 {
  def largestPerimeter(A: Array[Int]): Int = A
    .sorted
    .reverse
    .sliding(3)
    .collectFirst { case Array(a, b, c) if a < b + c => a + b + c }
    .getOrElse(0)
}
