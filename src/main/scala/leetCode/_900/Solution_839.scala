package leetCode._900

object Solution_839 {

  class Union(n: Int) {
    var cnt: Int = n
    var parent: Array[Int] = (0 until n).toArray

    def union(x: Int, y: Int): Unit = {
      if (find(x) != find(y)) cnt -= 1
      parent(find(x)) = find(y)
    }

    def find(x: Int): Int = {
      if (parent(x) != x) parent(x) = find(parent(x))
      parent(x)
    }
  }

  def numSimilarGroups(A: Array[String]): Int = {
    def isSimilar(a: String, b: String): Boolean = {
      var cnt = 0
      var idx = 0
      while (idx < a.length) {
        if (a(idx) != b(idx)) {
          cnt += 1
          if (cnt > 2) return false
        }
        idx += 1
      }
      true
    }

    val un = new Union(A.length)
    A.indices.foreach(i => (i + 1 until A.length).withFilter(j => un.find(i) != un.find(j)).foreach(j => if (isSimilar(A(i), A(j))) un.union(i, j)))
    un.cnt
  }

}
