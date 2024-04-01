package leetCode._900

import scala.collection.Searching.search

object Solution_828 {
  def uniqueLetterString(s: String): Int = {
    val locations = s.indices.foldLeft(Map.empty[Char, IndexedSeq[Int]]) {
      case (m, i) => m + (s.charAt(i) -> (m.getOrElse(s.charAt(i), IndexedSeq.empty[Int]) :+ i))
    }
    process(0, s, locations, 0)
  }

  private def nextOcc(occ: IndexedSeq[Int], index: Int): Option[Int] = {
    val currIndex = occ.search(index).insertionPoint
    if (currIndex == occ.length - 1) None
    else Some(occ(currIndex + 1))
  }

  private def prevOcc(occ: IndexedSeq[Int], index: Int): Option[Int] = {
    val currIndex = occ.search(index).insertionPoint
    if (currIndex == 0) None
    else Some(occ(currIndex - 1))
  }

  @scala.annotation.tailrec
  private def process(index: Int, string: String, locations: Map[Char, IndexedSeq[Int]], total: Int): Int = {
    if (index > string.length - 1) total
    else {
      val next = nextOcc(locations(string.charAt(index)), index)
      val prev = prevOcc(locations(string.charAt(index)), index)
      val contribution = (prev, next) match {
        case (None, None) => (index + 1) * (string.length - index)
        case (Some(po), None) => (index - po) * (string.length - index)
        case (None, Some(no)) => (index + 1) * (no - index)
        case (Some(po), Some(no)) => (index - po) * (no - index)
      }
      process(index + 1, string, locations, total + contribution)
    }
  }
}
