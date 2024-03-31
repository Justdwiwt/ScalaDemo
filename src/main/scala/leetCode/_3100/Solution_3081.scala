package leetCode._3100

import scala.collection.immutable.TreeSet

object Solution_3081 {
  def minimizeStringValue(s: String): String = {
    lazy val freq: Map[Char, Int] = ('a' to 'z').map(_ -> 0).toMap ++ s.groupBy(identity).mapValues(_.map(_ => 1).sum)
    lazy val ts = TreeSet(freq.toSeq.filterNot(_._1 == '?').map { case (c, f) => f -> c }: _*)
    lazy val sq: Seq[Char] = (0 until freq.getOrElse('?', 0)).foldLeft((ts, List.empty[Char])) { case ((set, list), _) =>
      lazy val (hf, hv) = set.head
      (set.tail + ((hf + 1, hv))) -> (hv +: list)
    }._2.sorted
    s.foldLeft((sq, List.empty[Char])) {
      case ((seq: Seq[Char], acc: Seq[Char]), '?') => (seq.tail, seq.head +: acc)
      case ((seq, acc), c) => seq -> (c +: acc)
    }._2.reverse.mkString
  }
}
