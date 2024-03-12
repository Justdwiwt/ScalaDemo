package leetCode._2300

object Solution_2224 {
  def convertTime(current: String, correct: String): Int = Array(60, 15, 5, 1)./:(0, (minutes(current) - minutes(correct)).abs) {
    case ((ops, minutesLeft), unit) => (ops + minutesLeft / unit, minutesLeft % unit)
  }._1

  def minutes(s: String): Int =
    s.take(2).toInt * 60 + s.takeRight(2).toInt
}
