package leetCode

object Solution_1156 {

  case class E(ch: Char, n: Int)

  @scala.annotation.tailrec
  def parser(l: List[Char], xs: List[E] = Nil): List[E] = l match {
    case Nil => xs
    case h :: t => xs match {
      case Nil => parser(t, E(h, 1) :: Nil)
      case E(y, n) :: t2 => if (y == h) parser(t, E(y, n + 1) :: t2) else parser(t, E(h, 1) :: xs)
    }
  }

  def maxRepOpt1(text: String): Int = {
    val m = scala.collection.mutable.HashMap[Char, Int]()
    text.foreach(ch => m += ch -> (m.getOrElse(ch, 0) + 1))

    @scala.annotation.tailrec
    def solve(xs: List[E], acc: Int): Int = xs match {
      case E(a, n1) :: E(_, n2) :: E(c, n3) :: _ =>
        if (n2 == 1 && a == c) solve(xs.tail, acc.max(m(a).min(n1 + n3 + 1)))
        else solve(xs.tail, acc.max(m(a).min(n1 + 1)))
      case E(a, n1) :: E(_, n2) :: Nil => acc.max(m(a).min(n1 + 1)).max(m(a).min(n2 + 1))
      case E(_, n1) :: Nil => acc.max(n1)
      case Nil => acc
    }

    solve(parser(text.toList, Nil), 0)
  }

}
