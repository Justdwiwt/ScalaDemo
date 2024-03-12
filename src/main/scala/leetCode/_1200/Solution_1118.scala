package leetCode._1200

object Solution_1118 {
  def numberOfDays(year: Int, month: Int): Int = {
    val diff = Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
    if (month != 2) return diff(month - 1)
    if (year % 4 != 0) return 28
    if (year % 100 != 0) return 29
    if (year % 400 != 0) return 28
    29
  }
}
