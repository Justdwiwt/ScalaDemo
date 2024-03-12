package leetCode._200

import leetCode.ListNode

object Solution_147 {
  def insertionSortList(head: ListNode): ListNode = {
    @scala.annotation.tailrec
    def sort(sorted: ListNode, unsorted: ListNode): ListNode = unsorted match {
      case null => sorted
      case _ =>
        val (n, ns) = headTail(unsorted)
        sort(insert(sorted, n), ns)
    }

    def headTail(list: ListNode): (ListNode, ListNode) = {
      val hd = list
      val tl = list.next
      hd.next = null
      (hd, tl)
    }

    @scala.annotation.tailrec
    def insert(sorted: ListNode, node: ListNode, prefixHead: ListNode = null, prefixLast: ListNode = null): ListNode = (sorted, prefixHead) match {
      case (null, null) =>
        node

      case (null, _) =>
        prefixLast.next = node
        prefixHead

      case (_, null) if node.x < sorted.x =>
        node.next = sorted
        node

      case _ if node.x < sorted.x =>
        node.next = sorted
        prefixLast.next = node
        prefixHead

      case (_, null) =>
        val (n, ns) = headTail(sorted)
        insert(ns, node, n, n)

      case _ =>
        val (n, ns) = headTail(sorted)
        prefixLast.next = n
        insert(ns, node, prefixHead, n)
    }

    sort(null, head)
  }
}
