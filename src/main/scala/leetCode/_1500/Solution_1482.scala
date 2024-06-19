package leetCode._1500

import scala.collection.mutable

object Solution_1482 {
  def minDays(bloomDay: Array[Int], m: Int, k: Int): Int = {
    def countBouquets(day: Int): Int = bloomDay
      .indices
      .iterator
      .filter(bloomDay(_) <= day)
      .foldLeft(List[(Int, Int)]()) {
        case ((start, end) :: tail, i) if i == end + 1 => (start, end + 1) :: tail
        case (ranges, i) => (i, i) :: ranges
      }
      .map { case (start, end) => (end - start + 1) / k }
      .sum

    @scala.annotation.tailrec
    def search(seq: mutable.IndexedSeq[Int]): Int = seq.size match {
      case 1 if countBouquets(seq.head) >= m => seq.head
      case 0 | 1 => -1
      case n if countBouquets(seq((n - 1) / 2)) >= m => search(seq.take((n - 1) / 2 + 1))
      case n => search(seq.drop((n - 1) / 2 + 1))
    }

    search(bloomDay.distinct.sorted)
  }
}
