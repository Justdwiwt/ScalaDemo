package leetCode._1400

import java.time.LocalDate
import java.time.temporal.ChronoUnit

object Solution_1360 {
  def daysBetweenDates(date1: String, date2: String): Int = {
    math.abs(LocalDate.parse(date1).until(LocalDate.parse(date2), ChronoUnit.DAYS)).asInstanceOf[Int]
  }
}
