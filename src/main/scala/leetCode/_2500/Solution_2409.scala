package leetCode._2500

object Solution_2409 {
  private val m = Seq(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)

  def d(s: String): Int = m
    .take(s.take(2).toInt - 1)
    .sum + s.drop(3).toInt

  def countDaysTogether(arriveAlice: String, leaveAlice: String, arriveBob: String, leaveBob: String): Int = {
    val a = d(arriveAlice).max(d(arriveBob))
    val l = d(leaveAlice).min(d(leaveBob))
    (l - a + 1).max(0)
  }
}
