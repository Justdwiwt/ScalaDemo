package leetCode

object Solution_839 {
  def numSimilarGroups(A: Array[String]): Int = {
    val parent = Array(A.indices: _*)

    def isSimilar(a: String, b: String) = a.zip(b).count(x => x._1 != x._2) == 2

    def union(a: Int, b: Int): Unit = parent(find(a)) = parent(find(b))

    def find(x: Int): Int = {
      if (parent(x) != x) parent(x) = find(parent(x))
      parent(x)
    }

    A.indices.foreach(i => (i + 1 until A.length)
      .withFilter(j => find(i) != find(j) && isSimilar(A(i), A(j)))
      .foreach(j => union(i, j)))

    parent.map(find).toSet.size
  }
}
