package leetCode._2700

import scala.collection.mutable

object Solution_2608 {
  def findShortestCycle(n: Int, edges: Array[Array[Int]]): Int = {
    val destMap = mutable.Map.empty[Int, List[Int]].withDefaultValue(List.empty)
    edges.foreach { case Array(e1, e2) =>
      destMap(e1) ::= e2
      destMap(e2) ::= e1
    }
    var mn = Int.MaxValue
    (0 until n).foreach(start => {
      def dfs(e: Int, seen: Set[Int], step: Int): Unit =
        if (step >= mn) {}
        else if (e == start) mn = math.min(mn, step)
        else destMap(e).filter(!seen.contains(_)).foreach(dfs(_, seen + e, step + 1))

      def f(e: Int): Unit = destMap(e).filter(_ != start).foreach(dfs(_, Set(e), 2))

      destMap(start).foreach(f)
    })
    if (mn == Int.MaxValue) -1 else mn
  }
}
