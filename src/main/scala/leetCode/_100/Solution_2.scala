package leetCode._100

class ListNode(var _x: Int = 0) {
  var next: ListNode = _
  var x: Int = _x
}

object Solution_2 {
  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    toListNode(addList(toList(l1).reverse, toList(l2).reverse, 0))
  }

  @scala.annotation.tailrec
  def toList(l1: ListNode, acc: List[Int] = Nil): List[Int] = l1 match {
    case null => acc
    case _ => toList(l1.next, l1.x :: acc)
  }

  @scala.annotation.tailrec
  def toListNode(l1: List[Int], acc: ListNode = null): ListNode = l1 match {
    case Nil => acc
    case h :: t =>
      val node = new ListNode(h)
      node.next = acc
      toListNode(t, node)
  }

  @scala.annotation.tailrec
  def addList(l1: List[Int], l2: List[Int], carry: Int, acc: List[Int] = Nil): List[Int] = (l1, l2) match {
    case (Nil, Nil) => if (carry != 0) carry :: acc else acc
    case (Nil, h :: t) => addList(Nil, t, (h + carry) / 10, (h + carry) % 10 :: acc)
    case (h :: t, Nil) => addList(Nil, t, (h + carry) / 10, (h + carry) % 10 :: acc)
    case (h :: t, h2 :: t2) => addList(t, t2, (h + h2 + carry) / 10, (h + h2 + carry) % 10 :: acc)
  }

}
