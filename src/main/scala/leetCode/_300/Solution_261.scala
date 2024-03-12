package leetCode._300

object Solution_261 {
  def validTree(n: Int, edges: Array[Array[Int]]): Boolean = {
    val graph = Array.ofDim[Int](n, n)
    edges.foreach(e => {
      graph(e(0))(e(1)) = 1
      graph(e(1))(e(0)) = 1
    })
    var st = List.empty[Int]
    st ::= 0
    val visited = Array.fill(n)(false)
    while (st.nonEmpty) {
      val cur = st.last
      st = st.reverse.tail.reverse
      visited(cur) = true
      (0 until n).foreach(i => {
        if (graph(cur)(i) == 1) {
          if (visited(i)) return false
          visited(i) = true
          graph(cur)(i) = 0
          graph(i)(cur) = 0
          st ::= i
        }
      })
    }
    (0 until n).foreach(i => if (!visited(i)) return false)
    true
  }
}
