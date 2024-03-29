package leetCode._1300

import leetCode.UnionFind

object Solution_1202 {
  def smallestStringWithSwaps(s: String, pairs: List[List[Int]]): String = {
    val uf = new UnionFind[Int]
    pairs.foreach(p => uf.union(p.head, p.last))

    val positionRelocations = s
      .indices
      .groupBy(uf.find)
      .values
      .flatMap(indexGroup => indexGroup.zip(indexGroup.sortBy(s)))
      .toMap

    s.indices.map(i => s(positionRelocations(i))).mkString
  }
}
