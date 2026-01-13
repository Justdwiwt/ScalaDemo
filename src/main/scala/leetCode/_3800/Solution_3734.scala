package leetCode._3800

object Solution_3734 {
  def lexPalindromicPermutation(s: String, target: String): String = {
    val n = s.length
    val half = n / 2

    val freq0 = s.foldLeft(Map.empty[Char, Int])((m, c) => m.updated(c, m.getOrElse(c, 0) + 1))

    val odds = freq0.collect { case (c, k) if k % 2 == 1 => c }.toList
    if (odds.size > 1) return ""

    val mid = odds.headOption.map(_.toString).getOrElse("")
    val freq1 = odds.headOption match {
      case Some(c) => freq0.updated(c, freq0(c) - 1)
      case None => freq0
    }

    val tLeft = target.take(half)

    val freq2 = tLeft.foldLeft(freq1)((m, c) => m.updated(c, m.getOrElse(c, 0) - 2))

    def hasNeg(m: Map[Char, Int]) = m
      .values
      .exists(_ < 0)

    def maxPos(m: Map[Char, Int]) = m
      .collect { case (c, k) if k > 0 => c }
      .reduceOption(_.max(_))

    if (!hasNeg(freq2)) {
      val right = mid + tLeft.reverse
      if (right > target.drop(half))
        return tLeft + right
    }

    @scala.annotation.tailrec
    def backtrack(i: Int, freq: Map[Char, Int]): Option[String] =
      if (i < 0) None
      else {
        val b = target(i)
        val freqBack = freq.updated(b, freq.getOrElse(b, 0) + 2)

        if (hasNeg(freqBack) || maxPos(freqBack).forall(_ <= b))
          backtrack(i - 1, freqBack)
        else {
          val ch = ('a' to 'z').find(c => c > b && freqBack.getOrElse(c, 0) > 0).get

          val freqNext = freqBack.updated(ch, freqBack(ch) - 2)

          val prefix = target.take(i) + ch

          val fill = ('a' to 'z').flatMap(c => List.fill(freqNext.getOrElse(c, 0) / 2)(c)).mkString

          val left = (prefix + fill).take(half)

          Some(left + mid + left.reverse)
        }
      }

    backtrack(half - 1, freq2).getOrElse("")
  }
}
