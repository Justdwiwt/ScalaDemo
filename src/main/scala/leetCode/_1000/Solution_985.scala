package leetCode._1000

object Solution_985 {
  def sumEvenAfterQueries(A: Array[Int], queries: Array[Array[Int]]): Array[Int] = queries
    .scanLeft(A.filter(_ % 2 == 0).sum) { case (sum, Array(v, i)) =>
      val prev = Option(A(i)).filter(_ % 2 == 0).getOrElse(0)
      A(i) += v
      val curr = Option(A(i)).filter(_ % 2 == 0).getOrElse(0)
      sum - prev + curr
    }
    .tail
}
