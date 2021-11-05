package leetCode

object Solution_2058 {
  def nodesBetweenCriticalPoints(head: ListNode): Array[Int] = {
    def critical(prev: Int, cur: Int, next: Int): Boolean =
      (cur < prev && cur < next) || (cur > prev && cur > next)

    @scala.annotation.tailrec
    def criticalPoints(head: ListNode, acc: List[Int], index: Int): List[Int] = head.next match {
      case null => acc
      case _ => head.next.next match {
        case null => acc
        case _ =>
          if (critical(head.x, head.next.x, head.next.next.x))
            criticalPoints(head.next, index :: acc, index + 1)
          else criticalPoints(head.next, acc, index + 1)
      }
    }

    @scala.annotation.tailrec
    def finder(critical: List[Int], mxDistance: Int, mnDistance: Int): Array[Int] = critical match {
      case one :: two :: c =>
        if (mnDistance == -1)
          finder(two :: c, two - one, two - one)
        else
          finder(two :: c, mxDistance + two - one, mnDistance.min(two - one))
      case _ => Array(mnDistance, mxDistance)
    }

    finder(criticalPoints(head, Nil, -1).reverse, -1, -1)
  }
}
