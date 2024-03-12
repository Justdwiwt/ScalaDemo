package leetCode._900

import scala.collection.mutable

object Solution_827 {

  class Node {
    var parent: Node = this
    var size: Int = 0
  }

  object Node {
    def find(x: Node): Node = {
      if (x.parent == x) return x
      x.parent = find(x.parent)
      x.parent
    }

    def merge(x: Node, y: Node): Boolean = {
      val px = find(x)
      val py = find(y)
      if (px == py) return false
      if (px.size > py.size) {
        py.parent = px
        px.size += py.size
      }
      else if (px.size < py.size) {
        px.parent = py
        py.size += px.size
      }
      else if (px.size == py.size) {
        py.parent = px
        px.size += py.size
      }
      true
    }
  }

  def largestIsland(grid: Array[Array[Int]]): Int = {
    val m = mutable.Map[(Int, Int), Node]().withDefaultValue(new Node())
    grid.indices.foreach(i => grid.indices.foreach(j => {
      m((i, j)) = new Node
      m((i, j)).size = grid(i)(j)
    }))
    grid.indices.foreach(i => grid.indices.withFilter(j => grid(i)(j) == 1).foreach(j => {
      if (j + 1 <= grid.length - 1 && grid(i)(j + 1) == 1) Node.merge(m((i, j)), m((i, j + 1)))
      if (i + 1 <= grid.length - 1 && grid(i + 1)(j) == 1) Node.merge(m((i, j)), m((i + 1, j)))
    }))
    var res = 0
    val s = mutable.Set[Node]()
    grid.indices.foreach(i => grid.indices.foreach(j => {
      if (m((i, j)).size > 0) {
        val p = Node.find(m((i, j)))
        s += p
        res = res.max(p.size)
      }
    }))
    grid.indices.foreach(i => grid.indices.withFilter(j => grid(i)(j) == 0).foreach(j => {
      val pl = Node.find(m((i, j - 1)))
      val pr = Node.find(m((i, j + 1)))
      val pu = Node.find(m((i + 1, j)))
      val pd = Node.find(m((i - 1, j)))
      val t = mutable.Set(pl, pr, pu, pd).intersect(s)
      if (t.isEmpty) res = res.max(1)
      else res = res.max(1 + t.toList.map(_.size).sum)
    }))
    res
  }

}
