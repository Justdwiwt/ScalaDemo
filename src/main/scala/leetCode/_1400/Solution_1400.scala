package leetCode._1400

object Solution_1400 {
  def canConstruct(s: String, k: Int): Boolean =
    !(s.length < k || s.groupBy(c => c).mapValues(l => l.length).values.withFilter(v => v % 2 == 1).map(_ => 1).sum > k)
}
