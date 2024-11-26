package leetCode._3400

// fixme: case 168/954 wrong answer
object Solution_3348 {
  @scala.annotation.tailrec
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

  private def check(num: String, t: Long): Boolean = {
    val product = num.map(_.asDigit).filter(_ != 0).product
    product % t == 0
  }

  private def find(num: String, t: Long): String = {
    val n = num.length

    def dfs(idx: Int, current: String, remainingT: Long): Option[String] = {
      if (idx == n) {
        if (check(current, t)) Some(current) else None
      } else {
        val curlmt = num(idx).asDigit
        val nextNumbers = (curlmt to 9).collect {
          case digit if digit != 0 =>
            val nextT = remainingT / gcd(digit, remainingT.toInt)
            dfs(idx + 1, current + digit.toString, nextT)
        }

        nextNumbers.collectFirst { case Some(res) => res }
      }
    }

    val res = dfs(0, "", t)

    res match {
      case Some(res) => res
      case None => "-1"
    }
  }

  def smallestNumber(num: String, t: Long): String =
    find(num, t)
}
