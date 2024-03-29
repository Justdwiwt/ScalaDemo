package leetCode._1200

object Solution_1171 {
  class ListNode(_x: Int = 0, _next: ListNode = null) {
    val next: ListNode = _next
    val x: Int = _x
  }

  def removeZeroSumSublists(head: ListNode): ListNode = {
    @scala.annotation.tailrec
    def f(node: ListNode, sums: Set[Int] = Set(0), acc: List[(Int, Int)] = List(0 -> 0)): List[(Int, Int)] = {
      lazy val xSum: Int = node.x + acc.headOption.map(_._2).getOrElse(0)
      lazy val (d: List[(Int, Int)], t: List[(Int, Int)]) = acc.span(_._2 != xSum)
      if (node == null) acc
      else if (sums.contains(xSum)) f(node.next, sums -- d.map(_._2), t)
      else f(node.next, sums + xSum, (node.x -> xSum) +: acc)
    }

    f(head).map(_._1).foldLeft(null: ListNode) { case (node, i) => new ListNode(i, node) }.next
  }
}
