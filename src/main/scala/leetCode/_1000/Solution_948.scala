package leetCode._1000

object Solution_948 {
  def bagOfTokensScore(tokens: Array[Int], P: Int): Int = {
    if (tokens.isEmpty) 0
    else {
      val sorted = tokens.sorted
      if (sorted.head > P) 0
      else f(sorted, P, sorted.sum, flag = true)
    }
  }

  @scala.annotation.tailrec
  def f(tokens: Array[Int], P: Int, res: Int, flag: Boolean): Int =
    if (flag) f(tokens.tail, P - tokens.head, res - tokens.head, flag = false)
    else {
      if (P >= res) tokens.length + 1
      else if (P >= res - tokens.last) tokens.length
      else f(tokens.init, P + tokens.last, res - tokens.last, flag = true)
    }
}
