package leetCode

object Solution_1185 {
  def dayOfTheWeek(day: Int, month: Int, year: Int): String = {
    var m = month
    var y = year
    if (m == 1 || m == 2) {
      m += 12
      y -= 1
    }
    val week = (day + 2 * m + 3 * (m + 1) / 5 + y + y / 4 - y / 100 + y / 400) % 7
    val string = Array("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    string(week)
  }
}
