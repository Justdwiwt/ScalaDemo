package leetCode

object Solution_396 {
  def maxRotateFunction(A: Array[Int]): Int = {
    val sum = A.sum
    val seed = ((0, 0) /: A) { case ((s, k), n) => (s + k * n, k + 1) }._1
    (A.indices :\ (seed, seed)) { case (i, (m, s)) =>
      val newS = s + sum - A(i) * A.length
      (m.max(newS), newS)
    }._1
  }
}
