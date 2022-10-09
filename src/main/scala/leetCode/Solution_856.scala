package leetCode

object Solution_856 {
  @scala.annotation.tailrec
  def f(lst: List[String], acc: List[String]): List[String] = lst match {
    case Nil if acc.length > 1 => f(acc, List())
    case Nil if acc.length == 1 => acc
    case x :: y :: z :: ys if x == "(" && y.forall(Character.isDigit) && z == ")" => f(ys, acc :+ (y.toInt * 2).toString)
    case y :: z :: ys if y.forall(Character.isDigit) && z.forall(Character.isDigit) => f(ys, acc :+ (y.toInt + z.toInt).toString)
    case x :: y :: ys if x == "(" && y == ")" => f(ys, acc :+ "1")
    case x :: xs => f(xs, acc :+ x)
    case _ => acc
  }

  def scoreOfParentheses(S: String): Int = f(S.toList.map(_.toString), List()).head.toInt
}
