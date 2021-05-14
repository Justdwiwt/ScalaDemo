package leetCode

object Solution_1694 {
  def reformatNumber(number: String): String = {
    var res = number
      .replaceAll(" ", "")
      .replaceAll("-", "")
      .grouped(3)
      .toSeq
    if (res.last.length == 1)
      res = res.dropRight(2) :+ res.init.last.take(2) :+ (res.init.last.drop(2) + res.last)
    res.mkString("-")
  }
}
