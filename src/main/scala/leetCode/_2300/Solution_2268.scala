package leetCode._2300

object Solution_2268 {
  def minimumKeypresses(s: String): Int = s
    .groupBy(identity)
    .mapValues(_.length)
    .toSeq
    .sortBy(-_._2)
    .zipWithIndex
    .foldLeft(0) { case (acc, (ch, cnt)) => acc + ((cnt / 9 + 1) * ch._2) }
}
