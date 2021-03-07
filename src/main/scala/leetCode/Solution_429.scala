package leetCode

object Solution_429 {

  class Node(var _value: Int) {
    var value: Int = _value
    var children: List[Node] = List()
  }

  def levelOrder(root: Node): List[List[Int]] = {
    @scala.annotation.tailrec
    def f(level: List[Node], res: List[List[Int]]): List[List[Int]] = level match {
      case Nil => res
      case _ =>
        val (next, value) = level./:((List.empty[Node], List.empty[Int]))((t, nd) => (t._1 ::: nd.children, nd.value :: t._2))
        f(next, value.reverse :: res)
    }

    Option(root)
      .map(nd => f(List(nd), List.empty[List[Int]]).reverse)
      .getOrElse(List.empty[List[Int]])
  }

}
