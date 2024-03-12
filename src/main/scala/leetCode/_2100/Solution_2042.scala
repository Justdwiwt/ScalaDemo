package leetCode._2100

object Solution_2042 {
  @scala.annotation.tailrec
  def f(s: List[Int]): Boolean = s match {
    case Nil => true
    case _ :: Nil => true
    case h :: g :: t if h < g => f(g :: t)
    case _ => false
  }

  def areNumbersAscending(s: String): Boolean =
    f(s.split(" ").filter(_.head.isDigit).map(_.toInt).toList)
}
