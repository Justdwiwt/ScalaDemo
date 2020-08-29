package leetCode

object Solution_948 {
  def bagOfTokensScore(tokens: Array[Int], P: Int): Int = {
    var sorted = tokens.sorted
    var power = P
    var score = 0
    var res = 0
    while (sorted.nonEmpty) {
      if (power >= sorted.head) {
        power = power - sorted.head
        score += 1
        res = res.max(score)
        sorted = sorted.tail
      } else {
        if (score <= 0) return res
        power += sorted.last
        score -= 1
        sorted = sorted.dropRight(1)
      }
    }
    res
  }
}
