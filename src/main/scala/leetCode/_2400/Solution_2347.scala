package leetCode._2400

object Solution_2347 {
  def bestHand(ranks: Array[Int], suits: Array[Char]): String =
    if (suits.min == suits.max) "Flush"
    else ranks.groupBy(identity).mapValues(_.length).values.max match {
      case 5 | 4 | 3 => "Three of a Kind"
      case 2 => "Pair"
      case _ => "High Card"
    }
}
