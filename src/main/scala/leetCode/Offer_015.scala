package leetCode

import scala.collection.mutable

object Offer_015 {
  def findAnagrams(s: String, p: String): List[Int] = {
    val m = mutable.HashMap.empty[Char, Int]
    p.foreach(updateMap(m, _, 1))

    s.indices.toList.filter(i => {
      if (i >= p.length) updateMap(m, s(i - p.length), 1)
      updateMap(m, s(i), -1)
      m.isEmpty
    }).map(_ - p.length + 1)
  }

  def updateMap(m: mutable.HashMap[Char, Int], ch: Char, incrementer: Int): Unit = m.get(ch) match {
    case Some(number) if number + incrementer == 0 => m -= ch
    case Some(number) => m += (ch -> (number + incrementer))
    case None => m += (ch -> incrementer)
  }
}
