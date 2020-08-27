package leetCode

object Solution_886 {
  def possibleBipartition(N: Int, dislikes: Array[Array[Int]]): Boolean = {
    val arr = Array.fill(N + 1, N + 1)(false)
    dislikes.foreach(i => {
      arr(i(0))(i(1)) = true
      arr(i(1))(i(0)) = true
    })
    val t = Array.fill(1 + N)(0)
    t(0) = Int.MaxValue
    f(arr, t, N)
  }

  //noinspection NoTailRecursionAnnotation
  def f(graph: Array[Array[Boolean]], col: Array[Int], n: Int): Boolean = {
    if (!col.contains(0)) true
    else {
      var q = List(col.indexOf(0))
      var color = 1
      while (q.nonEmpty) {
        q.foreach({ i =>
          col(i) match {
            case 0 => col(i) = color
            case _ => return false
          }
        })
        color = if (color == 1) 2 else 1
        q = q.flatMap(g(n, graph)).filter(h(color, col)).distinct
      }
      f(graph, col, n)
    }
  }

  def g(n: Int, graph: Array[Array[Boolean]])(x: Int): IndexedSeq[Int] = (1 to n).filter(graph(x))

  def h(color: Int, col: Array[Int])(x: Int): Boolean = col(x) != color

}
