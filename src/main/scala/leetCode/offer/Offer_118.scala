package leetCode.offer

object Offer_118 {
  def findRedundantConnection(edges: Array[Array[Int]]): Array[Int] = {
    val parent = Array.fill(edges.length + 1)(0)
    (1 to edges.length).foreach(i => parent(i) = i)
    edges.foreach(v => if (!union(v(0), v(1), parent)) return v)
    Array.fill(2)(0)
  }

  def union(a: Int, b: Int, parent: Array[Int]): Boolean = {
    if (find(a, parent) != find(b, parent)) {
      parent(find(a, parent)) = find(b, parent)
      return true
    }
    false
  }

  def find(a: Int, parent: Array[Int]): Int = {
    var t = a
    while (t != parent(t)) t = parent(t)
    t
  }
}
