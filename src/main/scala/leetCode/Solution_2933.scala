package leetCode

object Solution_2933 {
  def findHighAccessEmployees(access_times: List[List[String]]): List[String] = access_times
    .map(_.head)
    .distinct
    .filter(e => high(access_times.filter(_.head == e).map(a => minute(a(1))).sorted))

  private def high(times: List[Int]): Boolean =
    times.size > 2 && times.sliding(3).exists(t => t(2) - t.head < 60)

  private def minute(t: String): Int =
    t.take(2).toInt * 60 + t.drop(2).toInt
}
