package leetCode._600

import leetCode.TreeNode

import scala.collection.mutable

object Solution_572 {

  private class Node

  private type Key = (Option[Node], Option[Node], Int)
  private type TMap = mutable.Map[Key, Node]

  def isSubtree(s: TreeNode, t: TreeNode): Boolean = {
    val m = mutable.Map.empty[Key, Node]
    createMap(s, m)
    check(t, m).nonEmpty
  }

  private def createMap(t: TreeNode, m: TMap): Option[Node] =
    Option(t).map(n => m.getOrElseUpdate((createMap(n.left, m), createMap(n.right, m), n.value), new Node))

  private def check(t: TreeNode, s: TMap): Option[Option[Node]] = t match {
    case null => Some(None)
    case _ => check(t.left, s)
      .flatMap(l => check(t.right, s)
        .flatMap(r => s.get((l, r, t.value)).map(Some(_))))
  }

}
