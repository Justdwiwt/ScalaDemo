package leetCode

object Solution_1491 {
  def average(salary: Array[Int]): Double = salary
    .sortWith(_ < _)
    .take(salary.length - 1)
    .tail
    .sum * 1.0 / (salary.length - 2)
}
