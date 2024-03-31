package leetCode._1000

object Solution_943 {
  def shortestSuperstring(A: Array[String]): String = {
    val graph = buildGraph(A, cost)
    val dp = Array.fill(A.length, 1 << A.length)(100000)
    val path = Array.fill(A.length, 1 << A.length)(List[Int]())
    (1 until 1 << A.length).foreach(j => {
      A.indices.foreach(i => if (((j >> i) & 1) == 1) {
        if ((j - (1 << i)) == 0) {
          dp(i)(j) = A(i).length
          path(i)(j) = List(i)
        }
        else A
          .indices
          .withFilter(k => ((j >> k) & 1) == 1 && k != i)
          .foreach(k => if (dp(i)(j) > graph(k)(i) + dp(k)(j - (1 << i))) {
            dp(i)(j) = graph(k)(i) + dp(k)(j - (1 << i))
            path(i)(j) = path(k)(j - (1 << i)) ::: List(i)
          })
      })
    })
    val m = A.indices.map(dp(_)((1 << A.length) - 1)).zipWithIndex.minBy(_._1)._2
    val p = path(m)((1 << A.length) - 1)
    generateAns(A, p, graph)
  }

  private def generateAns(A: Array[String], path: List[Int], graph: Array[Array[Int]]): String =
    A(path.head) + path.zip(path.tail).map(x => A(x._2).substring(A(x._2).length - graph(x._1)(x._2), A(x._2).length)).mkString

  private def buildGraph(A: Array[String], f: (String, String) => Int): Array[Array[Int]] = {
    val graph = Array.fill(A.length, A.length)(0)
    A.indices.foreach(i => A.indices.withFilter(_ != i).foreach(j => graph(i)(j) = f(A(i), A(j))))
    graph
  }

  private def cost(s1: String, s2: String): Int = {
    var m = s1.length
    s1.indices.foreach(i => if (s2.startsWith(s1.substring(i, s1.length))) m = m.min(i))
    s2.length - s1.length + m
  }
}
