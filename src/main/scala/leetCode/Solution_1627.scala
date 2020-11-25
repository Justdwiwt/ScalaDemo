package leetCode

object Solution_1627 {
  def areConnected(n: Int, threshold: Int, queries: Array[Array[Int]]): List[Boolean] = {

    var diff = Array.emptyIntArray

    def find(x: Int): Int = if (diff(x) == x) diff(x) else {
      diff(x) = find(diff(x))
      diff(x)
    }

    var res = List.empty[Boolean]

    diff = Array.fill(n + 1)(0)
    (1 to n).foreach(i => diff(i) = i)
    (threshold + 1 to n).foreach(i => (i * 2 to n by i).foreach(j => if (find(i) != find(j)) diff(find(j)) = find(i)))
    queries.foreach(q => res ::= find(q.head) == find(q(1)))
    res.reverse
  }
}
