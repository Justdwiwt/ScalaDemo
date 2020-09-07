package leetCode

object Solution_457 {
  def fourSumCount(A: Array[Int], B: Array[Int], C: Array[Int], D: Array[Int]): Int = {
    val aPlusB = A.flatMap(a => B.map(b => a + b))
    val sum = aPlusB.groupBy(r => r).map({ case (s: Int, arr: Array[Int]) => (s, arr.length) })
    val total = C.flatMap(c => D.map(d => sum.getOrElse(-c - d, 0)))
    total.sum
  }
}
