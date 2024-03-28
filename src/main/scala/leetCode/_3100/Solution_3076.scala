package leetCode._3100

import scala.collection.immutable

object Solution_3076 {
  def shortestSubstrings(arr: Array[String]): Array[String] = {
    def substrs(s: String): immutable.IndexedSeq[String] =
      (1 to s.length).flatMap(s.sliding(_).toSeq.sorted.map(x => x))

    val idx = arr.zipWithIndex

    idx.map { case (str, i) => substrs(str)
      .find(sub => idx.forall { case (s, j) => i == j || !s.contains(sub) })
      .getOrElse("")
    }
  }
}
