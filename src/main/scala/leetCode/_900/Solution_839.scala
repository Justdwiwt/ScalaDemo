package leetCode._900

import leetCode.UnionFind

object Solution_839 {
  def numSimilarGroups(A: Array[String]): Int = {
    def isSimilar(s1: String, s2: String): Boolean = {
      val cnt = s1.zip(s2).count { case (c1, c2) => c1 != c2 }
      Seq(2, 0).contains(cnt)
    }

    val uf = new UnionFind[String]

    A
      .indices
      .dropRight(1)
      .flatMap(i => (i + 1 until A.length).withFilter(j => isSimilar(A(i), A(j))).map(x => uf.union(A(i), A(x))))

    A.map(uf.find).distinct.length
  }
}
