package leetCode

object Solution_950 {
  def deckRevealedIncreasing(deck: Array[Int]): Array[Int] = {
    if (deck.isEmpty) return Array[Int]()
    var t = deck.sortBy(i => -i)
    var res = Array[Int](t.head)
    t = t.tail
    while (t.nonEmpty) {
      res = Array(t.head) ++ Array(res.last) ++ res.dropRight(1)
      t = t.tail
    }
    res
  }
}
