package leetCode._2400

object Solution_2306 {
  def distinctNames(ideas: Array[String]): Long = {
    val grouped = ideas.groupBy(_.head).mapValues(_.map(_.tail).distinct)
    val cnt = grouped
      .flatMap { case (prefixA, suffixA) => grouped
        .withFilter { case (prefixB, _) => prefixA < prefixB }
        .map { case (prefixB, suffixB) => val same = suffixA.intersect(suffixB).length.toLong; ((prefixB, suffixB), same) }
        .map { case ((_, suffixB), same) => (suffixA.length - same) * (suffixB.length - same) }
      }
    cnt.sum * 2
  }
}
