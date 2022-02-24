package leetCode

import scala.collection.mutable

object Solution_2182 {
  def repeatLimitedString(s: String, repeatLimit: Int): String = {
    val m = s.groupBy(identity).mapValues(_.length)
    val pq = mutable.PriorityQueue[(Char, Int)](m.toSeq: _*)
    val res = new mutable.StringBuilder()
    while (pq.nonEmpty) {
      val (ch, freq) = pq.dequeue()
      val addFreq = freq.min(repeatLimit)
      (0 until addFreq).foreach(_ => res += ch)
      val re = freq - addFreq
      if (re > 0)
        if (pq.nonEmpty) {
          val (ch2, freq2) = pq.dequeue()
          res += ch2
          if (freq2 != 1) pq += ((ch2, freq2 - 1))
          pq += ((ch, re))
        } else return res.mkString
    }
    res.mkString
  }
}
