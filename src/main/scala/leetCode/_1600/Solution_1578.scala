package leetCode._1600

object Solution_1578 {
  def minCost(colors: String, neededTime: Array[Int]): Int = {
    @scala.annotation.tailrec
    def f(l: List[(Char, Int)], acc: Int): Int = l match {
      case Nil | _ :: Nil => acc
      case (a, x) :: (b, y) :: t if a == b => f((b, x.max(y)) :: t, acc + x.min(y))
      case _ => f(l.tail, acc)
    }

    f(colors.toList.zip(neededTime), 0)
  }
}
