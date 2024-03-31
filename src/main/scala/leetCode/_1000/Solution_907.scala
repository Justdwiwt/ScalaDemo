package leetCode._1000

object Solution_907 {
  def sumSubarrayMins(arr: Array[Int]): Int = {
    @scala.annotation.tailrec
    def inner(l: Seq[(Int, Int)], lastV: Int, lastI: Int, acc3: Long): Long =
      if (l.isEmpty) acc3 + lastV * (lastI + 1)
      else inner(l.tail, l.head._1, l.head._2, acc3 + lastV * (lastI - l.head._2))

    @scala.annotation.tailrec
    def f(i: Int, stack: Seq[(Int, Int)], acc: Long): Int = {
      lazy val s2: Seq[(Int, Int)] = (arr(i) -> i) +: stack.dropWhile(_._1 >= arr(i))
      if (i >= arr.length) (acc % 1000000007).toInt
      else f(i + 1, s2, inner(s2, 0, i + 1, acc))
    }

    f(0, Nil, 0)
  }
}
