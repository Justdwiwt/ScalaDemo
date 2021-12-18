package leetCode

object LCP_40 {
  def maxmiumScore(cards: Array[Int], cnt: Int): Int = {
    val sorted = cards.sorted
    var sum = 0
    var t = cnt
    var idx = cards.length - 1
    while (t > 0) {
      sum += sorted(idx)
      idx -= 1
      t -= 1
    }
    if (sum % 2 == 0) return sum
    (idx to 0 by -1).foreach(i => (idx + 1 until cards.length).foreach(j => {
      sum -= sorted(j)
      sum += sorted(i)
      if (sum % 2 == 0) return sum
      sum -= sorted(i)
      sum += sorted(j)
    }))
    0
  }
}
