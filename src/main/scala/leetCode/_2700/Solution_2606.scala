package leetCode._2700

object Solution_2606 {
  def maximumCostSubstring(s: String, chars: String, vals: Array[Int]): Int = {
    val m = chars.zip(vals).toMap.withDefault(_ - 'a' + 1)
    s.toList./:((0, 0)) { case ((max, cur), c) =>
      val nCurr = cur + m(c)
      (max.max(nCurr), nCurr.max(0))
    }._1
  }
}
