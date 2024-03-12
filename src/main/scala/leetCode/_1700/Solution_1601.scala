package leetCode._1700

object Solution_1601 {
  def maximumRequests(n: Int, requests: Array[Array[Int]]): Int = {
    def f(chosen: List[Array[Int]], rest: List[Array[Int]]): Int = rest match {
      case Nil =>
        if (chosen.map(_.head).groupBy(x => x).map(x => x._1 -> x._2.size) == chosen.map(_(1)).groupBy(x => x).map(x => x._1 -> x._2.size))
          chosen.size
        else 0
      case head :: tail => f(head :: chosen, tail).max(f(chosen, tail))
    }

    f(List[Array[Int]](), requests.toList)
  }
}
