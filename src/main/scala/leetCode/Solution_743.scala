package leetCode

import scala.collection.mutable

object Solution_743 {
  def networkDelayTime(times: Array[Array[Int]], N: Int, K: Int): Int = {
    val graph = mutable.Map[Int, Array[(Int, Int)]]()
    (0 until N).foreach(i => graph(i) = Array())
    times.indices.foreach(i => {
      val k = times(i)
      val e = graph(k(0) - 1)
      graph(k(0) - 1) = e :+ ((k(1) - 1, k(2)))
    })
    val res = path(graph.toMap, K - 1, N)
    if (res.contains(Int.MaxValue)) -1 else res.max
  }

  def path(graph: Map[Int, Array[(Int, Int)]], node: Int, N: Int): Array[Int] = {
    val vis = Array.fill[Boolean](N)(false)
    vis(node) = true
    val dis = Array.fill[Int](N)(Int.MaxValue)
    dis(node) = 0
    var prev = node
    (0 until N).foreach(_ => {
      graph(prev).foreach({ case (n, x) => if (!vis(n)) {
        val newDis = dis(prev) + x
        if (newDis < dis(n)) dis(n) = newDis
      }
      })
      var curMn = Int.MaxValue
      var cuMnNode = 0
      dis.indices.foreach(i => if (!vis(i)) {
        if (curMn > dis(i)) {
          curMn = dis(i)
          cuMnNode = i
        }
      })
      prev = cuMnNode
      vis(prev) = true
    })
    dis
  }
}
