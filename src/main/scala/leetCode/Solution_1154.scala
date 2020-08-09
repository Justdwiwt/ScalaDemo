package leetCode

object Solution_1154 {
  def dayOfYear(date: String): Int = {
    val arr = date.split("-")
    val year = arr(0).toInt
    val month = arr(1).toInt
    val day = arr(2).toInt
    new java.util.GregorianCalendar(year, month - 1, day).get(java.util.Calendar.DAY_OF_YEAR)
  }
}
