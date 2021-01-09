package leetCode

object Solution_8 {
  def myAtoi(str: String): Int = {
    @scala.annotation.tailrec
    def f(list: List[Char], num: Int, sign: Option[Char]): Int = list match {
      case ' ' :: rest if sign.isEmpty => f(rest, num, sign)
      case '-' :: rest if sign.isEmpty => f(rest, num, Some('-'))
      case '+' :: rest if sign.isEmpty => f(rest, num, Some('+'))
      case ch :: rest if ch >= '0' && ch <= '9' =>
        val t = ch - '0'
        if (sign.contains('+') && (num == Int.MaxValue / 10 && t > 7 || num > Int.MaxValue / 10)) Int.MaxValue
        else if (sign.contains('-') && (num == Int.MaxValue / 10 && t > 8 || num > Int.MaxValue / 10)) Int.MinValue
        else f(rest, num * 10 + t, sign.orElse(Some('+')))
      case _ => if (sign.contains('-')) -num else num
    }

    f(str.toList, 0, None)
  }
}
