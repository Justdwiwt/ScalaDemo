package leetCode._1200

object Solution_1154 {
  def dayOfYear(date: String): Int = date.split("-").map(_.toInt).toList match {
    case List(year, month, day) =>
      val isLeapYear = year % 100 != 0 && year % 4 == 0 || year % 400 == 0
      val daysInMonth = Array(31, if (isLeapYear) 29 else 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
      daysInMonth.take(month - 1).sum + day
    case _ => -1
  }
}
