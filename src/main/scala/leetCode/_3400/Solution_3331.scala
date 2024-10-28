package leetCode._3400

import scala.collection.mutable

object Solution_3331 {
  def findSubtreeSizes(parent: Array[Int], s: String): Array[Int] = {
    val n = parent.length
    val g = Array.fill(n)(mutable.ListBuffer[Int]())
    parent.indices.drop(1).foreach(i => g(parent(i)).append(i))

    val size = Array.fill(n)(0)
    val ancestor = Array.fill(26)(-1)
    dfs(0, g, s.toCharArray, ancestor, size)
    size
  }

  private def dfs(x: Int, g: Array[mutable.ListBuffer[Int]], s: Array[Char], ancestor: Array[Int], size: Array[Int]): Unit = {
    size(x) = 1
    val sx = s(x) - 'a'
    val old = ancestor(sx)
    ancestor(sx) = x

    g(x).foreach(y => {
      dfs(y, g, s, ancestor, size)
      val anc = ancestor(s(y) - 'a')
      size(if (anc < 0) x else anc) += size(y)
    })

    ancestor(sx) = old
  }
}
