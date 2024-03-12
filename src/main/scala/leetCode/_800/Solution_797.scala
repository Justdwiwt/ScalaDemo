package leetCode._800

object Solution_797 {
  def allPathsSourceTarget(graph: Array[Array[Int]]): List[List[Int]] = {
    def f(path: List[Int]): Stream[List[Int]] = graph(path.head)
      .toStream
      .flatMap(h => f(h :: path))
      .#::(path)

    f(List(0))
      .filter(_.head == graph.length - 1)
      .map(_.reverse)
      .toList
  }
}
