package leetCode._1000

object Solution_961 {
  def repeatedNTimes(A: Array[Int]): Int = {
    @scala.annotation.tailrec
    def f(l: List[Int], s: Set[Int]): Int = l match {
      case head :: tail => if (s.contains(head)) head else f(tail, s + head)
      case Nil => 0
    }

    f(A.toList, Set())
  }
}
