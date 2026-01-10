package leetCode._3800

object Solution_3723 {
  def maxSumOfSquares(num: Int, sum: Int): String =
    loop(num, sum, 0, new Array[Char](num))

  @scala.annotation.tailrec
  def loop(num: Int, sum: Int, i: Int, array: Array[Char]): String =
    if (i == num && sum > 0) ""
    else if (i == num) array.mkString
    else {
      val digit = math.min(sum, 9)
      array(i) = digit.asChar
      loop(num, sum - digit, i + 1, array)
    }

  implicit class ToChar(i: Int) {
    def asChar: Char = (i + '0').toChar
  }
}
