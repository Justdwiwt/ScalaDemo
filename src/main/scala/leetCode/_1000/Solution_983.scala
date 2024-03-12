package leetCode._1000

object Solution_983 {
  def mincostTickets(days: Array[Int], costs: Array[Int]): Int = {
    val diff = costs match {
      case Array(one, seven, thirty) => Map(1 -> one, 7 -> seven, 30 -> thirty)
      case _ => throw new Exception
    }
    days.indices.:\(IndexedSeq[Int]()) {
      case (i, dp) =>
        val mn = diff.map({ case (numDays, cost) =>
          val remaining = days.indexWhere(_ >= days(i) + numDays) match {
            case -1 => 0
            case j => dp(days.length - j - 1)
          }
          cost + remaining
        }).min
        dp :+ mn
    }.last
  }
}
