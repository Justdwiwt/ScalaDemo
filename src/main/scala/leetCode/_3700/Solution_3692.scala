package leetCode._3700

object Solution_3692 {
  def majorityFrequencyGroup(s: String): String = s
    .groupBy(identity)
    .toList
    .groupBy(_._2.length)
    .maxBy(p => (p._2.size, p._1))
    ._2
    .map(_._1)
    .mkString
}
