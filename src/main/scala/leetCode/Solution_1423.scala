package leetCode

object Solution_1423 {
  def maxScore(cardPoints: Array[Int], k: Int): Int = {
    var l = cardPoints.take(k).sum
    var r = 0
    var res = l
    (0 until k).foreach(i => {
      l -= cardPoints(k - 1 - i)
      r = r + cardPoints(cardPoints.length - 1 - i)
      res = res.max(l + r)
    })
    res
  }
}
