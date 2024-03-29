package leetCode._1200

object Solution_1185 {
  def dayOfTheWeek(day: Int, month: Int, year: Int): String = java.time.LocalDate
    .of(year, month, day)
    .getDayOfWeek
    .toString
    .toLowerCase
    .capitalize
}
