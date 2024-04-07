package leetCode._300

object Solution_261 {
  def validTree(n: Int, edges: Array[Array[Int]]): Boolean = {
    val graph = Array.ofDim[Int](n, n)
    edges.foreach(e => {
      graph(e.head)(e(1)) = 1
      graph(e(1))(e.head) = 1
    })

    @scala.annotation.tailrec
    def f(st: List[Int], visited: Array[Boolean]): Boolean = st match {
      case Nil => (0 until n).forall(visited(_))
      case cur :: tail =>
        visited(cur) = true
        val newStack = (0 until n).filter(i => graph(cur)(i) == 1 && !visited(i)).toList ::: tail
        if (newStack.exists(visited(_))) false
        else f(newStack, visited)
    }

    f(List(0), Array.fill(n)(false))
  }
}
