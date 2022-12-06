package leetCode

object Solution_2014 {
  def longestSubsequenceRepeatedK(s: String, k: Int): String = {
    @scala.annotation.tailrec
    def removeSub(s: String, t: String): Option[String] = (s, t) match {
      case (_, "") => Some(s)
      case _ => s.indexOf(t.head) match {
        case -1 => None
        case i => removeSub(s.drop(i + 1), t.tail)
      }
    }

    @scala.annotation.tailrec
    def repeated(s: String, k: Int)(t: String): Boolean = (t, k) match {
      case (_, 0) => true
      case ("", _) => true
      case _ => removeSub(s, t) match {
        case Some(rs) => repeated(rs, k - 1)(t)
        case None => false
      }
    }

    val hot = s
      .groupBy(identity)
      .mapValues(_.length)
      .toSeq
      .map(x => x._1.toString * (x._2 / k))
      .reduce(_ + _)

    val subs = (0 to s.length)
      .flatMap(hot.combinations(_).flatMap(_.permutations))

    subs.sortBy(x => (x.length, x)).reverse.find(repeated(s, k)).get
  }
}
