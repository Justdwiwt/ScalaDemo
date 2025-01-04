package leetCode.LCP

import scala.collection.mutable.ListBuffer

object LCP_54 {
  def minimumCost(cost: Array[Int], roads: Array[Array[Int]]): Long = {
    val n = cost.length
    if (n == 1) return cost.head

    val edges = Array.fill(n)(ListBuffer.empty[Int])
    roads.foreach(r => {
      edges(r.head).append(r(1))
      edges(r(1)).append(r.head)
    })

    val dcc = new FindVDcc(n, edges)

    if (dcc.dcc.size == 1) return cost.min

    val vec = ListBuffer.empty[Long]
    dcc.dcc.foreach(c => {
      var cnt = 0
      var mn = Long.MaxValue
      c.foreach(x => if (dcc.cut(x)) cnt += 1 else mn = mn.min(cost(x)))
      if (cnt == 1) vec.append(mn)
    })

    vec.sorted.dropRight(1).sum
  }
}

class FindVDcc(v: Int, edges: Array[ListBuffer[Int]]) {
  private val dfn = Array.fill(v)(0)
  private val low = Array.fill(v)(0)
  val cut: Array[Boolean] = Array.fill(v)(false)
  private val stack = new Array[Int](v)
  private var top = 0
  var dcc: ListBuffer[ListBuffer[Int]] = ListBuffer.empty[ListBuffer[Int]]

  private var total = 0

  (0 until v).foreach(i => if (dfn(i) == 0) tarjan(i, i))

  private def tarjan(root: Int, sn: Int): Unit = {
    total += 1
    dfn(sn) = total
    low(sn) = total
    stack(top) = sn
    top += 1
    var flag = 0
    edges(sn).foreach(fn => if (dfn(fn) == 0) {
      tarjan(root, fn)
      low(sn) = low(sn).min(low(fn))
      if (low(fn) >= dfn(sn)) {
        flag += 1
        if (sn != root || flag > 1) cut(sn) = true
        val newDcc = ListBuffer.empty[Int]
        var t = 0
        while ( {
          top -= 1
          t = stack(top)
          newDcc.append(t)
          t != fn
        }) {}
        newDcc.append(sn)
        dcc.append(newDcc)
      }
    } else low(sn) = low(sn).min(dfn(fn)))
  }
}
