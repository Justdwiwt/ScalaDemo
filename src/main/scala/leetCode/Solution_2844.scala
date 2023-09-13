package leetCode

object Solution_2844 {
  def minimumOperations(num: String): Int =
    f(num.reverse.toList, found0 = false, found5 = false, 0)

  @scala.annotation.tailrec
  private def f(chars: List[Char], found0: Boolean, found5: Boolean, rm: Int): Int = chars match {
    case Nil => rm - (if (found0) 1 else 0)
    case ('2' | '7') :: _ if found5 => rm - 1
    case ('5' | '0') :: _ if found0 => rm - 1
    case '0' :: tail => f(tail, found0 = true, found5 = found5, rm + 1)
    case '5' :: tail => f(tail, found0, found5 = true, rm + 1)
    case _ :: tail => f(tail, found0, found5, rm + 1)
  }
}
