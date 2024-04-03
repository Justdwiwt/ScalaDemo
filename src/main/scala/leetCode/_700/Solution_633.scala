package leetCode._700

object Solution_633 {
  private val set = collection.immutable.SortedSet((0 to 70000).map(i => i.toLong * i): _*)

  def judgeSquareSum(c: Int): Boolean = set.exists(x => set.contains(c - x))
}
