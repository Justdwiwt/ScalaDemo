package leetCode._1700

object Solution_1650 {
  class Node(var _value: Int) {
    var value: Int = _value
    var left: Node = _
    var right: Node = _
    var parent: Node = _
  }


  def lowestCommonAncestor(p: Node, q: Node): Node = {
    @scala.annotation.tailrec
    def f(curP: Node, curQ: Node): Node =
      if (curP == curQ) curP
      else {
        val nextP = Option(curP).map(_.parent).getOrElse(q)
        val nextQ = Option(curQ).map(_.parent).getOrElse(p)
        f(nextP, nextQ)
      }

    f(p, q)
  }
}
