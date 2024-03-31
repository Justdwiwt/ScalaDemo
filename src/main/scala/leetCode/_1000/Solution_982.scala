package leetCode._1000

object Solution_982 {
  def countTriplets(A: Array[Int]): Int = {
    val cnt = A.flatMap(i => A.map(i & _)).groupBy(identity).mapValues(_.length)
    A.foldLeft(0)((res, i) => res + cnt.filterKeys(x => (x & i) == 0).values.sum)
  }
}
