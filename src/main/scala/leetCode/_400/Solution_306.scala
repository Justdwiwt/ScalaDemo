package leetCode._400

object Solution_306 {
  def isAdditiveNumber(num: String): Boolean =
    if (num.length == 2) false
    else (0 until (num.length - 1) / 2).exists(i => (i + 1 until num.length - 1).exists(j =>
      if (num.length - j - 1 >= (i + 1).max(j - i)) isValid(num.substring(0, i + 1), num.substring(i + 1, j + 1), num.substring(j + 1))
      else false
    ))

  @scala.annotation.tailrec
  private def isValid(num1: String, num2: String, remain: String): Boolean =
    if (remain.isEmpty) true
    else if (num1.charAt(0) == '0' && num1.length > 1) false
    else if (num2.charAt(0) == '0' && num2.length > 1) false
    else {
      val sum = (num1.toLong + num2.toLong).toString
      if (!remain.startsWith(sum)) false
      else isValid(num2, sum, remain.substring(sum.length))
    }
}
