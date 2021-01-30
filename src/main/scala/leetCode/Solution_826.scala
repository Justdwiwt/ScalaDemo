package leetCode

object Solution_826 {
  def maxProfitAssignment(d: Array[Int], p: Array[Int], w: Array[Int]): Int =
    f(d.zip(p).toList.sortBy(-_._2), w.toList)

  @scala.annotation.tailrec
  def f(dp: List[(Int, Int)], w: List[Int], acc: Int = 0): Int = (dp, w) match {
    case (Nil, _) => acc
    case (_, Nil) => acc
    case (h :: t, _) => f(t, w.filter(_ < h._1), acc + h._2 * w.count(_ >= h._1))
  }
}
