package leetCode._2800

object Solution_2798 {
  def numberOfEmployeesWhoMetTarget(hours: Array[Int], target: Int): Int =
    hours.count(_ >= target)
}
