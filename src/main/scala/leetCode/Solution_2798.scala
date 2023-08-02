package leetCode

object Solution_2798 {
  def numberOfEmployeesWhoMetTarget(hours: Array[Int], target: Int): Int =
    hours.count(_ >= target)
}
