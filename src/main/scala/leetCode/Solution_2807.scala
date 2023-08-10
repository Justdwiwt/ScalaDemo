package leetCode

object Solution_2807 {

  class ListNode(_x: Int = 0, _next: ListNode = null) {

    var next: ListNode = _next

    var x: Int = _x

  }

  def insertGreatestCommonDivisors(head: ListNode): ListNode = {

    def f(node: ListNode): ListNode = node match {
      case node if node.next != null =>
        val x = node.x
        val y = node.next.x
        val g = BigInt(x).gcd(y)
        new ListNode(x, new ListNode(g.toInt, f(node.next)))

      case last => last
    }

    f(head)

  }
}
