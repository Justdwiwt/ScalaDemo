package leetCode._400

import leetCode.ListNode

import scala.language.implicitConversions

object Solution_328 {

  object Converse {

    implicit def nodeToList(x: ListNode): List[Int] = x match {
      case a if a == null => Nil
      case b if b != null => b.x :: nodeToList(b.next)
    }

    implicit def listToNode(x: List[Int]): ListNode = x match {
      case Nil => null
      case h :: t =>
        val head = new ListNode(h)
        head.next = listToNode(t)
        head
    }
  }

  def oddEvenList(head: ListNode): ListNode = {
    import Converse._

    val list = head.zipWithIndex.partition({ case (_, y) => (y + 1) % 2 == 1 })
    list._1.map(_._1) ++ list._2.map(_._1)
  }
}
