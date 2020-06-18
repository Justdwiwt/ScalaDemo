package leetCode

object Solution_1012 {
  def numDupDigitsAtMostN(N: Int): Int = {
    var res = 0
    (0 to N).foreach(i => {
      if (i >= 11) {
        val t = i.toString
        if (t.distinct.length < t.length) res += 1
      }
    })
    res
  }
}
