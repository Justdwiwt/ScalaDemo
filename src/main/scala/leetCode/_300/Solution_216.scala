package leetCode._300

object Solution_216 {
  def combinationSum3(k: Int, n: Int): List[List[Int]] =
    (1 to 9).combinations(k).filter(_.sum == n).map(_.toList).toList
}
