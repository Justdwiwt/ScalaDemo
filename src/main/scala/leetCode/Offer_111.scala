package leetCode

object Offer_111 {
  case class Node(dest: String, wt: Double)

  def calcEquation(equations: List[List[String]], values: Array[Double], queries: List[List[String]]): Array[Double] = {
    val g = equations.zip(values.toList)./:(Map[String, List[Node]]())((m, n) =>
      m + (n._1.head -> (m.getOrElse(n._1.head, Nil)
        :+ Node(n._1(1), n._2)), n._1(1) -> (m.getOrElse(n._1(1), Nil)
        :+ Node(n._1.head, 1 / n._2))))

    queries./:(List[Double]())((acc, v) => acc :+ dfs(v.head, v(1), g, Nil)).toArray
  }

  def dfs(s: String, d: String, m: Map[String, List[Node]], visited: List[String]): Double =
    if (visited.contains(s)) -1.0
    else if (!(m.contains(s) && m.contains(d))) -1.0
    else if (s == d) 1.0
    else m.getOrElse(s, Nil)./:(0.0)((_, v) => {
      val res = dfs(v.dest, d, m, visited :+ s)
      if (res != -1.0) return res * v.wt
      else -1
    })
}
