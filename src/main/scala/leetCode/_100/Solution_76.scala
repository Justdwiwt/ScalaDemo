package leetCode._100

import scala.collection.mutable

object Solution_76 {
  def minWindow(s: String, t: String): String = {
    var res = (-1, 0, 0)
    var from = 0
    var to = 0
    val unique = mutable.Map.empty[Char, Int]

    t.foreach(c => unique += c -> (unique.getOrElse(c, 0) + 1))

    val required = unique.size
    var formed = 0
    val windowCnt = mutable.Map.empty[Char, Int]

    while (to < s.length) {
      val r = s.charAt(to)
      val cnt = windowCnt.getOrElse(r, 0)
      windowCnt += r -> (cnt + 1)
      if (unique.isDefinedAt(r) && windowCnt(r) == unique(r)) formed += 1
      while (from <= to && formed == required) {
        val l = s.charAt(from)
        if (res._1 == -1 || to - from + 1 < res._1) res = (to - from + 1, from, to)
        windowCnt.put(l, windowCnt(l) - 1)
        if (unique.contains(l) && windowCnt.getOrElse(l, 0) < unique.getOrElse(l, 0)) formed -= 1
        from += 1
      }
      to += 1
    }
    res._1 match {
      case -1 => ""
      case _ => s.substring(res._2, res._3 + 1)
    }
  }
}
