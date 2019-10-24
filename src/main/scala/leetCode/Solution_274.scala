package leetCode

import scala.util.Sorting.quickSort

object Solution_274 {
  def hIndex(citations: Array[Int]): Int = {
    quickSort(citations)
    citations.indices.foreach(i => if (citations(i) >= citations.length - i) return citations.length - i)
    0
  }
}
