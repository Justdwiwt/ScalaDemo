package leetCode._2500

import scala.collection.mutable.ListBuffer

object Solution_2479 {
  // fixme: wrong answer
  case class TrieNode(child: Array[TrieNode] = Array.fill(2)(null))

  val root: TrieNode = TrieNode()
  val bits: Int = 46
  var s: Array[Long] = _
  var res: Long = 0
  val adj: ListBuffer[ListBuffer[Int]] = ListBuffer.fill(100)(ListBuffer.empty)

  private def add(value: Long): Unit = {
    var node: TrieNode = root
    (bits to 0 by -1).foreach(i => {
      val cur: Int = ((value >> i) & 1).toInt
      if (node.child(cur) == null) node.child(cur) = TrieNode()
      node = node.child(cur)
    })
  }

  private def query(value: Long): Long = {
    var node: TrieNode = root
    var res: Long = 0
    var i = bits
    while (i >= 0) {
      val cur: Int = ((value >> i) & 1).toInt
      if (node.child(1 - cur) != null) {
        res += (1L << i)
        node = node.child(1 - cur)
      }
      else if (node.child(cur) != null) node = node.child(cur)
      else i = -1
      i -= 1
    }
    res
  }

  private def dfs(node: Int, prev: Int, values: Array[Int]): Long = {
    var result: Long = values(node)
    adj(node).foreach(e => if (e != prev) result += dfs(e, node, values))
    s(node) = result
    result
  }

  private def process(node: Int, prev: Int): Unit = {
    val ans: Long = query(s(node))
    if (ans > res) res = ans
    adj(node).foreach(next => if (next != prev) process(next, node))
    add(s(node))
  }

  def maxXor(n: Int, edges: Array[Array[Int]], values: Array[Int]): Long = {
    s = Array.fill(n)(0)
    (0 until n).foreach(adj(_) = ListBuffer.empty)
    edges.foreach(edge => {
      adj(edge.head).append(edge(1))
      adj(edge(1)).append(edge.head)
    })
    dfs(0, -1, values)
    process(0, -1)
    res
  }
}
