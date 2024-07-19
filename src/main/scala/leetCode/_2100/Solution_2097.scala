package leetCode._2100

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object Solution_2097 {
  def validArrangement(pairs: Array[Array[Int]]): Array[Array[Int]] = {
    val res = Array.ofDim[Int](pairs.length, 2)
    val outDegree = mutable.Map.empty[Int, Int]
    val out = mutable.Map.empty[Int, ListBuffer[Int]]

    pairs.foreach(pair => {
      val (from, to) = (pair(0), pair(1))
      outDegree.update(from, outDegree.getOrElse(from, 0) + 1)
      outDegree.update(to, outDegree.getOrElse(to, 0) - 1)

      if (!out.contains(from)) out(from) = ListBuffer.empty[Int]
      if (!out.contains(to)) out(to) = ListBuffer.empty[Int]

      out(from) += to
    })

    var start = pairs.head.head
    outDegree.foreach { case (key, value) => if (value == 1) start = key }

    val buffer = mutable.ArrayBuffer.empty[Int]

    def dfs(node: Int): Unit = {
      val st = mutable.Stack[Int]()
      st.push(node)

      while (st.nonEmpty) {
        val u = st.top
        if (out(u).isEmpty) {
          buffer.prepend(u)
          st.pop()
        } else {
          val v = out(u).remove(0)
          st.push(v)
        }
      }
    }

    dfs(start)

    pairs.indices.foreach(i => res(i) = Array(buffer(i), buffer(i + 1)))

    res
  }
}
