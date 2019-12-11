package leetCode

object Solution_373 {
  def kSmallestPairs(A: Array[Int], B: Array[Int], k: Int): List[List[Int]] = {
    A.flatMap(x => B.map(y => List(x, y))).sortBy({ case x :: y :: Nil => x + y }).toList.take(k)
  }
}
