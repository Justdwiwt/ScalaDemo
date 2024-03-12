package leetCode._900

object Solution_802 {
  def eventualSafeNodes(graph: Array[Array[Int]]): List[Int] = f(
    graph.map(_.length),
    graph.indices./:(Array.fill(graph.length)(List.empty[Int]))((g, i) => {
      graph(i).foreach(n => g(n) = i +: g(n))
      g
    }),
    Array.fill(graph.length)(false),
    graph.indices.filter(graph(_).isEmpty).toList
  )

  @scala.annotation.tailrec
  def f(out: Array[Int], graph: Array[List[Int]], res: Array[Boolean], queue: List[Int]): List[Int] =
    if (queue.isEmpty) res.indices.filter(res).toList
    else f(out, graph, res, queue.flatMap(n => {
      res(n) = true
      graph(n)
    })./:(List.empty[Int])((nq, n) => {
      out(n) -= 1
      if (out(n) == 0) n +: nq
      else nq
    }))
}
