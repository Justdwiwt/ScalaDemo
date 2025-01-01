package leetCode._3000

object Solution_2941 {
  def maxGcdSum(nums: Array[Int], k: Int): Long = {
    val initialAnswer = if (k == 1) nums.max.toLong * nums.max else 0L

    def updateGcdMap(g1: Map[Int, (Long, Int)], num: Int): Map[Int, (Long, Int)] = {
      val newGcdMap = g1.foldLeft(Map(num -> (num.toLong, 1))) { case (g2, (g, (sum, length))) =>
        val gnew = BigInt(g).gcd(BigInt(num)).toInt
        val newSum = sum + num
        val newLength = length + 1
        g2.get(gnew) match {
          case Some((existingSum, _)) if existingSum >= newSum => g2
          case _ => g2 + (gnew -> (newSum, newLength))
        }
      }
      newGcdMap
    }

    @scala.annotation.tailrec
    def cal(g1: Map[Int, (Long, Int)], remainingNums: List[Int], curr: Long): Long = remainingNums match {
      case Nil => curr
      case num :: tail =>
        val g2 = updateGcdMap(g1, num)
        val newAnswer = g2.collect { case (g, (sum, length)) if length >= k => sum * g }.foldLeft(curr)(math.max)
        cal(g2, tail, newAnswer)
    }

    cal(Map(), nums.toList, initialAnswer)
  }
}
