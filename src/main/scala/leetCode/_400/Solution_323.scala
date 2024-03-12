package leetCode._400

object Solution_323 {
  def countComponents(n: Int, edges: Array[Array[Int]]): Int = {
    var res = n
    val parents = Array.fill(res)(-1)
    edges.foreach(e => {
      val r1 = find(parents, e(0))
      val r2 = find(parents, e(1))
      if (r1 != r2) {
        parents(r1) = r2
        res -= 1
      }
    })
    res
  }

  def find(parents: Array[Int], x: Int): Int = {
    var root = x
    while (parents(root) != -1) root = parents(root)
    root
  }
}
