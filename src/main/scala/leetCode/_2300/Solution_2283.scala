package leetCode._2300

object Solution_2283 {
  @scala.annotation.tailrec
  def digitCount(num: String, i: Int = 0): Boolean =
    if (i == num.length) true
    else if (num(i) - '0' == num.count(_.toInt - '0' == i)) digitCount(num, i + 1)
    else false
}
