package leetCode._1100

import scala.collection.immutable.BitSet

object Solution_1061 {
  def smallestEquivalentString(s1: String, s2: String, baseStr: String): String = {
    val groups = s1.zip(s2)
      .map { case (c1, c2) => BitSet(c1, c2) }
      .foldLeft(List.empty[BitSet])((groups, n) => {
        groups.partition(bs => (bs & n).nonEmpty) match {
          case (has, hasNot) => has.foldLeft(n)(_ | _) :: hasNot
        }
      })

    baseStr.map(c => groups.collectFirst { case bs if bs.contains(c) => bs.min.toChar }.getOrElse(c))
  }
}
