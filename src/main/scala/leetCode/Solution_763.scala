package leetCode

import scala.collection.mutable

object Solution_763 {
  def partitionLabels(S: String): List[Int] = {
    val m = mutable.Map.empty[Char, (Int, Int)]
    S.zipWithIndex.foreach({ case (c, i) => m += c -> (m.get(c).map(_._1).getOrElse(i), i) })
    m.values.toSeq.sorted./:(List.empty[(Int, Int)]) {
      case (Nil, (start, end)) => List((start, end))
      case (soFar@(s1, e1) :: rest, interval@(s2, e2)) =>
        if (s2 <= e1) (s1, e1.max(e2)) :: rest
        else interval :: soFar
    }.reverse.map({ case (start, end) => end - start + 1 })
  }
}
