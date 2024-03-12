package leetCode._1000

object Solution_945 {
  def minIncrementForUnique(A: Array[Int]): Int = {
    @scala.annotation.tailrec
    def f(l: List[Int], pre: Int, step: Int): Int = l match {
      case Nil => step
      case head :: tail if head > pre => f(tail, head, step)
      case head :: tail if head <= pre => f(tail, pre + 1, step + (pre - head + 1))
    }

    if (A.isEmpty) 0 else f(A.sorted.toList.tail, A.sorted.toList.head, 0)
  }
}
