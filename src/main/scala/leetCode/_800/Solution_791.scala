package leetCode._800

object Solution_791 {
  def customSortString(S: String, T: String): String = {
    T.sortBy(S.zipWithIndex.toMap.withDefault(_ => Int.MaxValue))
  }
}
