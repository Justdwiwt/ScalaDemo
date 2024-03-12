package leetCode._1500

import scala.collection.mutable

object Solution_1494 {
  def minNumberOfSemesters(n: Int, dependencies: Array[Array[Int]], k: Int): Int = {
    val pre = Array.fill(n)(0)
    dependencies.foreach(i => {
      i(0) -= 1
      i(1) -= 1
      pre(i(1)) |= (1 << i(0))
    })
    val all = 1 << n
    val dp = Array.fill(all)(0)
    (0 until all).foreach(i => dp(i) = n)
    dp(0) = 0
    (0 until all).foreach(state => {
      var next = 0
      (0 until n).foreach(i => if ((state & pre(i)) == pre(i)) next |= 1 << i)
      next &= ~state
      var sub = next
      while (sub > 0) {
        if (Integer.bitCount(sub) <= k) dp(state | sub) = dp(state | sub).min(dp(state) + 1)
        sub = (sub - 1) & next
      }
    })
    dp((1 << n) - 1)
  }
}

class Graph[T] {
  private val graph = mutable.HashMap[T, List[T]]()

  def add(src: T, dst: T): Unit = graph.put(src, dst :: graph.getOrElse(src, Nil))

  def biadd(x: T, y: T): Unit = {
    add(x, y)
    add(y, x)
  }

  def items(): mutable.HashMap[T, List[T]] = graph

  def get(x: T): List[T] = if (graph.contains(x)) graph(x) else {
    graph.put(x, Nil)
    get(x)
  }
}

case class Edge[T](src: T, dst: T)

class Topology[T] {
  def isUnique(ret: List[List[T]]): Boolean = ret.forall(_.length == 1)

  def build_graph(l: List[Edge[T]], inDegrees: mutable.HashMap[T, Int]): (mutable.HashMap[T, Int], Graph[T]) = {
    val graph = new Graph[T]()
    l.foreach({ case Edge(x, y) => graph.add(x, y); inDegrees(y) += 1 })
    (inDegrees, graph)
  }

  def min_topology_sort_steps(inDegrees: mutable.HashMap[T, Int], graph: Graph[T], limit: Int): Int = {
    val n = inDegrees.size
    var nPoints = 0
    var r = 0
    var Q = inDegrees.keySet.withFilter(v => inDegrees(v) == 0).map(v => v).toSeq

    def f(v: T): Int = graph.get(v).count(x => inDegrees(x) == 1)

    while (Q.nonEmpty) {
      Q = Q.sortBy(x => -f(x))
      var nQ = if (Q.length <= limit) Seq.empty[T] else Q.slice(limit, Q.length)
      Q = Q.slice(0, limit)
      r += 1
      nPoints += Q.length
      Q.foreach(v => graph.get(v).foreach(x => {
        inDegrees(x) -= 1
        if (inDegrees(x) == 0) nQ = nQ :+ x
      }))
      Q = nQ
    }
    if (nPoints == n) r else -1
  }
}

object Solution_1494_2 {
  def minNumberOfSemesters(n: Int, dependencies: Array[Array[Int]], k: Int): Int = {
    val tp = new Topology[Int]()
    val seqs = dependencies.toList.map({ case Array(a, b) => Edge[Int](a, b) })
    val inDegress = mutable.HashMap[Int, Int]()
    (1 to n).foreach(i => inDegress.put(i, 0))
    tp.build_graph(seqs, inDegress) match {
      case (deg, g) =>
        tp.min_topology_sort_steps(deg, g, k)
    }
  }
}
