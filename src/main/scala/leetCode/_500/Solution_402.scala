package leetCode._500

object Solution_402 {
  def removeKdigits(num: String, k: Int): String = {
    @scala.annotation.tailrec
    def f(strAcc: String, recurStr: String, n: Int): String = {
      if (n == 0) strAcc + recurStr
      else if (recurStr.length <= n) strAcc
      else {
        val min = recurStr.take(n + 1).zipWithIndex.minBy(_._1)
        f(strAcc :+ min._1, recurStr.substring(min._2 + 1), n - min._2)
      }
    }

    @scala.annotation.tailrec
    def g(str: String): String = {
      if (str.isEmpty) "0"
      else if (str.head == '0') g(str.tail)
      else str
    }

    g(f("", num, k))
  }

  case class Zipper(left: List[Int], value: Int, right: List[Int]) {
    def toList: List[Int] = List(left.reverse, List(value), right).flatten
  }

  @scala.annotation.tailrec
  def go(zipper: Zipper, k: Int): Zipper = {
    if (k == 0) zipper match {
      case Zipper(Nil, 0, Nil) => Zipper(Nil, 0, Nil)
      case Zipper(Nil, 0, x :: xs) => go(Zipper(Nil, x, xs), 0)
      case z => z
    } else zipper match {
      case Zipper(Nil, _, Nil) => Zipper(Nil, 0, Nil)
      case Zipper(Nil, 0, x :: xs) => go(Zipper(Nil, x, xs), k)
      case Zipper(Nil, head, x :: xs) =>
        if (head > x) go(Zipper(Nil, x, xs), k - 1)
        else go(Zipper(List(head), x, xs), k)
      case Zipper(left :: ls, head, x :: xs) =>
        if (head >= left && head > x) go(Zipper(ls, left, x :: xs), k - 1)
        else go(Zipper(head :: left :: ls, x, xs), k)
      case Zipper(left :: ls, _, Nil) => go(Zipper(ls, left, Nil), k - 1)
    }
  }


  def removeKdigits2(num: String, k: Int): String = num.map(_.asDigit).toList match {
    case Nil => "0"
    case x :: xs => go(Zipper(List.empty, x, xs), k).toList.mkString
  }
}
