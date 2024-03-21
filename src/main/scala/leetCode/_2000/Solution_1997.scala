package leetCode._2000

object Solution_1997 {
  def firstDayBeenInAllRooms(nextVisit: Array[Int]): Int = {
    val M = 1000000007
    val dp = Array.fill(nextVisit.length)(0L)
    nextVisit.indices.tail.foreach(day => dp(day) = (2 + 2 * dp(day - 1) - dp(nextVisit(day - 1)) + M) % M)
    (dp.last % M).toInt
  }
}
