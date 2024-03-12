package leetCode._1400

object Solution_1353 {
  case class Node(start: Int, end: Int, left: Node, right: Node, var flag: Boolean = true)

  def maxEvents(events: Array[Array[Int]]): Int = {
    val sorted = events.sortWith(_ (1) < _ (1))
    val mn = events.minBy(_.head)
    val mx = events.maxBy(_ (1))
    val root = build(mn.head, mx(1))
    var res = 0
    sorted.foreach(x => if (attend(root, x.head, x(1))) res += 1)
    res
  }

  def attend(node: Node, start: Int, end: Int): Boolean = {
    if (node == null || start > node.end || node.start > end || !node.flag) return false
    if (node.start == node.end) {
      node.flag = false
      return true
    }
    var res = attend(node.left, start, end)
    if (!res) res = attend(node.right, start, end)
    node.flag = node.left.flag || node.right.flag
    res
  }

  def build(start: Int, end: Int): Node = {
    if (start < end) {
      val a = (start + end) / 2
      return Node(start, end, build(start, a), build(a + 1, end))
    }
    Node(start, end, null, null)
  }
}
