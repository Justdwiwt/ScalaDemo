package leetCode._1000

object Solution_950 {
  def deckRevealedIncreasing(deck: Array[Int]): Array[Int] =
    deck.sorted.:\(Seq.empty[Int]) {
      case (n, s :+ l) => n +: l +: s
      case (n, _) => Seq(n)
    }.toArray
}
