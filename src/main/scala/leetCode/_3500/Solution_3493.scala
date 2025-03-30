package leetCode._3500

object Solution_3493 {
  def numberOfComponents(properties: Array[Array[Int]], k: Int): Int = {
    val n = properties.length
    val djs = Array.tabulate(n)(identity)

    def root(i: Int): Int =
      if (djs(i) == i) i
      else {
        djs(i) = root(djs(i))
        djs(i)
      }

    def join(i: Int, j: Int): Unit =
      djs(root(j)) = root(i)

    val propertySets: Array[Set[Int]] = properties.map(_.toSet)

    propertySets.indices.foreach(i => ((i + 1) until propertySets.length)
      .withFilter(j => propertySets(i).intersect(propertySets(j)).size >= k)
      .foreach(join(i, _)))

    djs.indices.map(root).distinct.size
  }
}
