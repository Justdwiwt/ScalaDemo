package leetCode._900

import scala.collection.mutable

object Solution_873 {
  def lenLongestFibSubseq(A: Array[Int]): Int = {
    val m = mutable.Map.empty[(Int, Int), Int].withDefaultValue(2)
    val st = A.toSet

    A.indices.drop(2).foreach(j => (1 until j)
      .withFilter(i => A(j) - A(i) < A(i) && st.contains(A(j) - A(i)))
      .foreach(i => m.update((A(i), A(j)), m((A(j) - A(i), A(i))) + 1)))

    m.values.reduceOption(_.max(_)).getOrElse(0)
  }
}
