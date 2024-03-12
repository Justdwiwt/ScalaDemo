package leetCode.offer

object Offer_025 {
  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
  }

  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    @scala.annotation.tailrec
    def add(l1: List[Int], l2: List[Int], carry: Int = 0, res: ListNode = null): ListNode = (l1, l2) match {
      case (Nil, Nil) if carry == 0 => res
      case (Nil, Nil) => new ListNode(carry, res)
      case (h1 :: t1, Nil) => add(t1, Nil, (h1 + carry) / 10, new ListNode((h1 + carry) % 10, res))
      case (Nil, h2 :: t2) => add(Nil, t2, (h2 + carry) / 10, new ListNode((h2 + carry) % 10, res))
      case (h1 :: t1, h2 :: t2) => add(t1, t2, (h1 + h2 + carry) / 10, new ListNode((h1 + h2 + carry) % 10, res))
    }

    @scala.annotation.tailrec
    def collect(ll1: ListNode, ll2: ListNode, toAdd1: List[Int], toAdd2: List[Int]): ListNode =
      if (ll1.next == null && ll2.next == null) add(ll1.x :: toAdd1, ll2.x :: toAdd2)
      else if (ll1.next == null) collect(ll1, ll2.next, toAdd1, ll2.x :: toAdd2)
      else collect(ll1.next, ll2, ll1.x :: toAdd1, toAdd2)

    collect(l1, l2, Nil, Nil)
  }
}
