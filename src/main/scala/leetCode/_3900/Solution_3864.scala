package leetCode._3900

object Solution_3864 {
  def minCost(s: String, encCost: Int, flatCost: Int): Long = {
    def getCost(ones: Long, len: Long): Long =
      if (ones != 0) ones * len * encCost else flatCost

    def subCost(from: Int, to: Int): (Int, Long) = {
      val len = to - from
      if (len % 2 == 1) {
        val ones = s.slice(from, to).count(_ == '1')
        (ones, getCost(ones, len))
      } else {
        val (lOnes, lCost) = subCost(from, from + len / 2)
        val (rOnes, rCost) = subCost(from + len / 2, to)
        val ones = lOnes + rOnes
        val cost = getCost(ones, len).min(lCost + rCost)
        (ones, cost)
      }
    }

    subCost(0, s.length)._2
  }
}
