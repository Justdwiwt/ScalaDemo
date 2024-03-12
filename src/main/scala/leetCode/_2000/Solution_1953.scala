package leetCode._2000

object Solution_1953 {
  def numberOfWeeks(milestones: Array[Int]): Long = {
    val m = milestones.map(_.toLong).max
    val s = milestones.map(_.toLong).sum - m
    if (m > s + 1) 2 * s + 1 else m + s
  }
}
