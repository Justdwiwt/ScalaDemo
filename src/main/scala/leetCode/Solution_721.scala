package leetCode

object Solution_721 {
  def accountsMerge(accounts: List[List[String]]): List[List[String]] = {
    val parent = accounts.indices.toArray

    @annotation.tailrec
    def root(p: Int): Int = {
      if (p != parent(p)) {
        parent(p) = parent(parent(p))
        root(parent(p))
      } else p
    }

    def union(p: Int, q: Int): Unit = {
      val P = root(p)
      val Q = root(q)
      parent(P) = Q
    }

    val (_, idxNameTable) = accounts.zipWithIndex.foldLeft((Map[String, Int](), Map[Int, String]())) {
      case ((idxMailMap, idxNameMap), (account, i)) =>
        val m = account.tail.foldLeft(idxMailMap)((map, mail) => {
          if (map.contains(mail)) union(i, map(mail))
          map + (mail -> i)
        })
        (m, idxNameMap + (i -> account.head))
    }

    val map: Map[Int, List[String]] = accounts.zipWithIndex.foldLeft(Map[Int, List[String]]()) {
      case (m, (account, i)) =>
        val r = root(i)
        m.updated(r, account.tail ::: m.getOrElse(r, List()))
    }.map({ case (key, value) => (key, idxNameTable(key) :: value.distinct.sorted) })
    map.values.toList
  }
}
