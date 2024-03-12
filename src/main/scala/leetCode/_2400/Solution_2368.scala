package leetCode._2400

object Solution_2368 {
  def reachableNodes(n: Int, edges: Array[Array[Int]], restricted: Array[Int]): Int = {
    val graph = {
      val zero = Map[Int, List[Int]]().withDefaultValue(List.empty)
      edges./:(zero)((acc, arr) => {
        val a = arr.head
        val b = arr(1)
        acc.updated(a, acc(a) :+ b).updated(b, acc(b) :+ a)
      })
    }

    @scala.annotation.tailrec
    def f(nodes: List[Int], restricted: Set[Int], seen: Set[Int], amount: Int): Int = nodes match {
      case Nil => amount
      case head :: tail if restricted.contains(head) || seen.contains(head) => f(tail, restricted, seen, amount)
      case head :: tail => f(tail ++ graph(head), restricted, seen + head, amount + 1)
    }

    f(0 :: graph(0), restricted.toSet, Set.empty, 0)
  }
}
