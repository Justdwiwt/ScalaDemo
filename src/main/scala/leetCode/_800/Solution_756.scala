package leetCode._800

object Solution_756 {
  def pyramidTransition(bottom: String, allowed: List[String]): Boolean = {
    val map = scala.collection.mutable.Map.empty[String, scala.collection.mutable.Set[Char]]
    allowed.foreach(s => {
      val key = s.substring(0, 2)
      if (!map.contains(key)) map(key) = scala.collection.mutable.Set.empty[Char]
      map(key) += s(2)
    })

    def dfs(row: String, nextRow: String): Boolean =
      if (row.length == 1) true
      else if (nextRow.length == row.length - 1) dfs(nextRow, "")
      else {
        val key = row.substring(nextRow.length, nextRow.length + 2)
        if (!map.contains(key)) false
        else map(key).exists(e => dfs(row, nextRow + e))
      }

    dfs(bottom, "")
  }
}
