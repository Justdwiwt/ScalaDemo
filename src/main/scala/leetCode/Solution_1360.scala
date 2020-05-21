package leetCode

import java.time.LocalDate
import java.time.temporal.ChronoUnit

object Solution_1360 {
  def daysBetweenDates(date1: String, date2: String): Int = {
    Math.abs(LocalDate.parse(date1).until(LocalDate.parse(date2), ChronoUnit.DAYS)).asInstanceOf[Int]
  }
}
