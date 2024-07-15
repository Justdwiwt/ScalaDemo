package leetCode._3300

object Solution_3217 {
  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
  }

  def modifiedList(nums: Array[Int], head: ListNode): ListNode = {
    lazy val st = nums.toSet

    @scala.annotation.tailrec
    def f(node: ListNode, acc: List[Int]): List[Int] =
      if (node == null) acc
      else f(node.next, node.x +: acc)

    f(head, Nil).filterNot(st.contains).foldLeft(null: ListNode) { case (prev, x) => new ListNode(x, prev) }
  }
}
