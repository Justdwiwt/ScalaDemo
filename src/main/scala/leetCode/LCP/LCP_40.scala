package leetCode.LCP

object LCP_40 {
  def maxmiumScore(cards: Array[Int], cnt: Int): Int = {
    val sorted = cards.sorted
    val n = sorted.length
    val initialSum = sorted.takeRight(cnt).sum

    if (initialSum % 2 == 0) initialSum
    else {
      val x = sorted(n - cnt)
      val res = replaceSum(sorted, cnt, initialSum, x)
      val replacementSum = (n - cnt + 1 until n).collectFirst {
        case i if sorted(i) % 2 != x % 2 => replaceSum(sorted, cnt, initialSum, sorted(i))
      }

      res.max(replacementSum.getOrElse(0))
    }
  }

  private def replaceSum(cards: Array[Int], cnt: Int, s: Int, x: Int): Int = (cards.length - cnt - 1 to 0 by -1)
    .collectFirst { case i if cards(i) % 2 != x % 2 => s - x + cards(i) }
    .getOrElse(0)
}
