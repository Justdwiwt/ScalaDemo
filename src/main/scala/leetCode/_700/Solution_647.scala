package leetCode._700

object Solution_647 {
  def countSubstrings(s: String): Int = s
    .indices
    .flatMap(i => Seq(i, i + 1).flatMap(j => (i to 0 by -1).zip(j until s.length).takeWhile(p => s(p._1) == s(p._2)).map(_ => true)))
    .size
}
