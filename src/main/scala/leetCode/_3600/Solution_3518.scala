package leetCode._3600

object Solution_3518 {
  private def factorial(n: Int): Int =
    (1 to n).product

  private def calculatePermutations(freq: Map[Char, Int]): Int = {
    val total = freq.values.sum
    val totalFactorial = factorial(total)
    val denominator = freq.values.map(factorial).product
    totalFactorial / denominator
  }

  def smallestPalindrome(s: String, k: Int): String = {
    val n = s.length
    val m = n / 2

    val total = s.take(m).foldLeft(Map.empty[Char, Int])((acc, c) => acc.updated(c, acc.getOrElse(c, 0) + 1))

    val perm = calculatePermutations(total)
    if (perm < k) return ""

    val result = (0 until m).foldLeft((List.empty[Char], total, k)) { case ((leftS, freq, remainingK), _) =>
      ('a' to 'z').foldLeft((leftS, freq, remainingK)) { case ((leftAcc, leftFreq, currentK), ch) =>
        leftFreq.get(ch) match {
          case Some(count) if count > 0 =>
            val updatedFreq = leftFreq.updated(ch, count - 1)
            val permLeft = calculatePermutations(updatedFreq)

            if (permLeft >= currentK) (leftAcc :+ ch, updatedFreq, currentK)
            else (leftAcc, leftFreq, currentK - permLeft)
          case _ => (leftAcc, leftFreq, currentK)
        }
      }
    }

    val (leftS, _, _) = result

    val rightS = leftS.reverse.mkString
    val middle = if (n % 2 == 1) s(n / 2).toString else ""
    leftS.mkString + middle + rightS
  }
}
