package leetCode._800

import scala.collection.mutable

object Solution_792 {
  def numMatchingSubseq(s: String, words: Array[String]): Int = {
    val m = mutable.Map.empty[Char, List[String]]
    words.foreach(x => m(x.head) = x.tail :: m.getOrElse(x.head, Nil))
    s.foreach(c => if (m.contains(c)) {
      val t = m(c)
      m -= c
      t.foreach(x => if (x.nonEmpty) m(x.head) = x.tail :: m.getOrElse(x.head, Nil))
    })
    words.length - m.map({ case (_, str) => if (str.isEmpty) 1 else str.size }).sum
  }
}
