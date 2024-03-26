package leetCode._1500

object Solution_1411 {
  // fixme

  //  private object Color extends Enumeration {
  //    type Color = Value
  //    val Red, Yellow, Green = Value
  //  }
  //
  //  import Color._
  //
  //  private type Block = (Color, Color, Color)
  //
  //  private val ValidBlocks: Set[Block] = Color
  //    .values
  //    .flatMap(c1 => (Color.values - c1).flatMap(c2 => (Color.values - c2).map((c1, c2, _))))
  //
  //  private val ValidNeighbors = ValidBlocks
  //    .flatMap(b1 => ValidBlocks
  //      .withFilter(b2 => b1._1 != b2._1 && b1._2 != b2._2 && b1._3 != b2._3)
  //      .map((b1, _)))
  //    .groupBy(_._1)
  //    .mapValues(_.map(_._2))
  //
  //  private val M = 1000000007
  //
  //  def numOfWays(n: Int): Int = {
  //    assert(1 <= n && n <= 5000)
  //
  //    (2 to n)
  //      .foldLeft(ValidBlocks.map(_ -> 1).toMap) {
  //        case (counts, _) => counts
  //          .toSeq
  //          .flatMap { case (block, count) => ValidNeighbors(block).map(_ -> count) }
  //          .groupBy(_._1)
  //          .mapValues(_.map(_._2).reduce((count1, count2) => (count1 + count2) % M))
  //      }
  //      .values
  //      .reduce[Int] { case (count1, count2) => (count1 + count2) % M }
  //  }
}
