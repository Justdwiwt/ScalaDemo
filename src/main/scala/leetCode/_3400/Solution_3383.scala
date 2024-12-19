package leetCode._3400

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Solution_3383 {
  def minRunesToAdd(n: Int, crystals: Array[Int], flowFrom: Array[Int], flowTo: Array[Int]): Int = {
    val g = Array.fill(n)(ArrayBuffer.empty[Int])
    flowFrom.zip(flowTo).foreach { case (from, to) => g(from).append(to) }

    val vis = Array.fill(n)(false)

    def dfs(v: Int): Unit = {
      vis(v) = true
      g(v).foreach(w => if (!vis(w)) dfs(w))
    }

    crystals.foreach(v => if (!vis(v)) dfs(v))

    val sid = Array.fill(n)(-1)
    var sccCnt = 0
    val dfn = Array.fill(n)(0)
    var dfsClock = 0
    val st = mutable.Stack[Int]()

    def tarjan(v: Int): Int = {
      dfsClock += 1
      dfn(v) = dfsClock
      var lowV = dfsClock
      st.push(v)
      g(v).foreach(w => {
        if (!vis(w)) {
          if (dfn(w) == 0) {
            val lowW = tarjan(w)
            lowV = lowV.min(lowW)
          } else lowV = lowV.min(dfn(w))
        }
      })
      if (dfn(v) == lowV) {
        var continue = true
        while (continue) {
          val w = st.pop()
          dfn(w) = Int.MaxValue
          sid(w) = sccCnt
          if (w == v) continue = false
        }
        sccCnt += 1
      }
      lowV
    }

    (0 until n).foreach(i => if (dfn(i) == 0 && !vis(i)) tarjan(i))

    val deg = Array.fill(sccCnt)(0)
    flowFrom.zip(flowTo).foreach { case (from, to) =>
      if (!vis(to) && sid(from) != sid(to)) deg(sid(to)) += 1
    }

    deg.count(_ == 0)
  }
}
