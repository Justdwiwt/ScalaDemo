package leetCode._1100

object Solution_1055 {
  def shortestWay(source: String, target: String): Int = {
    val ch1 = source.toCharArray
    val ch2 = target.toCharArray
    val charCounts = source.groupBy(identity).mapValues(_.length).toMap

    if (ch2.exists(!charCounts.contains(_))) return -1

    @scala.annotation.tailrec
    def findShortestWay(tgtIndex: Int, res: Int): Int =
      if (tgtIndex >= target.length) res
      else {
        val (newTgtIndex, _) = ch1.foldLeft((tgtIndex, false)) {
          case ((i, _), c) if i < target.length && c == ch2(i) => (i + 1, true)
          case ((i, found), _) => (i, found)
        }
        findShortestWay(newTgtIndex, res + 1)
      }

    findShortestWay(0, 0)
  }
}
