package leetCode._500

object Solution_454 {
  def fourSumCount(A: Array[Int], B: Array[Int], C: Array[Int], D: Array[Int]): Int = {
    val aPlusB = A.flatMap(i => B.map(i + _)).groupBy(identity).mapValues(_.length)

    val cPlusD = C.flatMap(i => D.map(i + _)).groupBy(identity).mapValues(_.length)

    aPlusB.map(tuple => {
      val (v: Int, cnt: Int) = tuple
      cPlusD.getOrElse(-v, 0) * cnt
    }).sum
  }
}
