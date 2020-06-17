package leetCode

object Solution_1014 {
  def maxScoreSightseeingPair(A: Array[Int]): Int = {
    A.indices.tail.foldLeft(A.head -> -1) {
      case ((_left, _res), i) =>
        val res = _res.max(_left + A(i) - i)
        val left = _left.max(A(i) + i)
        (left, res)
    }._2
  }
}
