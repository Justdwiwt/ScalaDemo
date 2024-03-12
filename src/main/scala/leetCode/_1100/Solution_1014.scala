package leetCode._1100

object Solution_1014 {
  def maxScoreSightseeingPair(A: Array[Int]): Int =
    A./:((0, 0))((a, b) => (a._1.max(b + a._2), b.max(a._2) - 1))._1
}
