package leetCode._700

object Solution_646 {
  def findLongestChain(pairs: Array[Array[Int]]): Int = {
    var upper = Int.MinValue
    var res = 0
    pairs.sortBy(a => a(1)).foreach({
      case p if p.head > upper =>
        res += 1
        upper = p(1)
      case _ =>
    })
    res
  }
}
