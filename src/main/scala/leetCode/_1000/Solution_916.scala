package leetCode._1000

import scala.collection.mutable

object Solution_916 {
  def wordSubsets(A: Array[String], B: Array[String]): List[String] = {
    val m = mutable.HashMap.empty[Char, Int]
    B.foreach(s => s.groupBy(ch => ch).mapValues(_.length).foreach(e => if (!m.contains(e._1) || m(e._1) < e._2) m(e._1) = e._2))

    def f(s: String): Boolean = {
      val m2 = s.groupBy(ch => ch).mapValues(_.length)
      m.keys.withFilter(ch => !m2.contains(ch) || m(ch) > m2(ch)).foreach(_ => return false)
      true
    }

    A.withFilter(s => f(s)).map(s => s).toList
  }
}
