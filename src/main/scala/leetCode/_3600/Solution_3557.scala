package leetCode._3600

object Solution_3557 {
  def maxSubstrings(word: String): Int = {
    val n = word.length
    if (n < 4) return 0

    @scala.annotation.tailrec
    def loop(i: Int, dpPrev: Int, dpMap: Map[Int, Int], memory: Map[Int, Int]): Int =
      if (i > n) dpPrev
      else {
        val dpI0 = dpPrev
        val memoryUpdated =
          if (i >= 4) {
            val ch4 = word.charAt(i - 4) - 'a'
            val oldVal = memory.getOrElse(ch4, -1)
            val newVal = oldVal.max(dpMap.getOrElse(i - 4, 0))
            memory.updated(ch4, newVal)
          } else memory

        val endCh = word.charAt(i - 1) - 'a'
        val dpI = memoryUpdated.get(endCh) match {
          case Some(v) if v != -1 => dpI0.max(1 + v)
          case _ => dpI0
        }

        loop(i + 1, dpI, dpMap.updated(i, dpI), memoryUpdated)
      }

    loop(1, 0, Map(0 -> 0), Map.empty)
  }
}
