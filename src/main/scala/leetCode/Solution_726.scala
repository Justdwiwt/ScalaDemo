package leetCode

object Solution_726 {

  case class E(l: Map[String, Int]) {
    def +(that: E): E =
      E((l /: that.l) { case (map, (k, v)) => map + (k -> (v + map.getOrElse(k, 0))) })

    def *(that: Int): E =
      E(l.map({ case (k, v) => (k, that * v) }))
  }

  val zero: E = E(Map.empty[String, Int])

  @scala.annotation.tailrec
  def f(l: List[Char], acc: List[E]): List[E] = l match {
    case Nil => acc
    case '(' :: t => f(t, zero :: acc)
    case ')' :: t => f(t, update(acc, zero))
    case h :: t if h.isLetter => f(t.dropWhile(x => x.isLower | x.isDigit), getFirst(l) :: acc)
    case h :: t if h.isDigit => f(t.dropWhile(x => x.isDigit), (acc.head * getInt(l)) :: acc.tail)
  }

  def getInt(l: List[Char]): Int = l.takeWhile(_.isDigit).mkString.toInt

  def getFirst(l: List[Char]): E = {
    val part = l.tail.takeWhile({ ch => ch.isLower || ch.isDigit })
    val p1 = part.takeWhile(_.isLower)
    val p2 = part.dropWhile(_.isLower)
    val cnt = p2 match {
      case Nil => 1
      case _ => p2.mkString.toInt
    }
    E(Map((l.head :: p1).mkString -> cnt))
  }

  @scala.annotation.tailrec
  def update(mem: List[E], acc: E = zero): List[E] = mem match {
    case `zero` :: t => acc :: t
    case h :: t => update(t, h + acc)
    case _ => Nil
  }

  def countOfAtoms(formula: String): String = {
    f(formula.toList, Nil).reduce(_ + _).l.toSeq.sortBy(_._1).map({ case (k, 1) => k case (k, v) => k + v.toString }).mkString
  }

}
