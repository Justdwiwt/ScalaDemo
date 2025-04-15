package leetCode._3600

import scala.collection.mutable

object Solution_3510 {
  class Node(var value: BigInt, val idx: Int) {
    var prev: Node = _
    var next: Node = _
  }

  case class Pair(sum: BigInt, pos: Int)

  implicit val pairOrdering: Ordering[Pair] = Ordering.by(p => (p.sum, p.pos))

  def minimumPairRemoval(nums: Array[Int]): Int = {
    val n = nums.length
    if (n <= 1) return 0
    val nodes = Array.tabulate(n)(i => new Node(BigInt(nums(i)), i))
    nums.indices.drop(1).foreach(i => {
      nodes(i).prev = nodes(i - 1)
      nodes(i - 1).next = nodes(i)
    })

    val P = nodes.clone()

    val ts = mutable.TreeSet.empty[Pair]
    var cnt = 0
    nums.indices.drop(1).foreach(i => {
      if (nodes(i - 1).value > nodes(i).value) cnt += 1
      ts += Pair(nodes(i - 1).value + nodes(i).value, nodes(i - 1).idx)
    })

    var res = 0

    def iterateSegment(from: Node, until: Node): List[Node] = {
      var cur = from
      val buf = mutable.ListBuffer.empty[Node]
      while (cur != null && (cur ne until)) {
        buf += cur
        cur = cur.next
      }
      buf.toList
    }

    while (cnt > 0) {
      if (ts.isEmpty) return res
      val minPair = ts.head
      ts -= minPair
      val cur = P(minPair.pos)
      if (cur == null || cur.next == null) {}
      else {
        val it1 = if (cur.prev != null) cur.prev else cur
        val tmp = cur.next
        if (tmp == null) {}
        else {
          val it2 = if (tmp.next != null) tmp.next else tmp
          val seg = iterateSegment(it1, it2)
          seg.foreach(node => if (node.next != null) {
            ts -= Pair(node.value + node.next.value, node.idx)
            if (node.value > node.next.value) cnt -= 1
          })
          cur.value = minPair.sum
          val afterTmp = tmp.next
          cur.next = afterTmp
          if (afterTmp != null) afterTmp.prev = cur
          P(tmp.idx) = null
          var node = it1
          while (node != null && node.next != null && (node ne it2)) {
            ts += Pair(node.value + node.next.value, node.idx)
            if (node.value > node.next.value) cnt += 1
            node = node.next
          }
          res += 1
        }
      }
    }
    res
  }
}
