package leetCode

object Solution_413 {
  def numberOfArithmeticSlices(A: Array[Int]): Int = A
    .indices
    .drop(2)
    .scan(0)((cur, j) => if (A(j) - A(j - 1) == A(j - 1) - A(j - 2)) cur + 1 else 0)
    .sum
}
