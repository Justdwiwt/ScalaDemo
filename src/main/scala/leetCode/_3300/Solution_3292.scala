package leetCode._3300

object Solution_3292 {
  private def prefixFunction(s: String): Vector[Int] = {
    val n = s.length
    s.indices.drop(1).foldLeft(Vector.fill(n)(0))((pi, i) => {
      @scala.annotation.tailrec
      def computePrefix(j: Int): Int =
        if (j > 0 && s(i) != s(j)) computePrefix(pi(j - 1))
        else if (s(i) == s(j)) j + 1
        else j

      pi.updated(i, computePrefix(pi(i - 1)))
    })
  }

  def minValidStrings(words: Array[String], target: String): Int = {
    val targetLen = target.length
    val initialPs = Vector.fill(targetLen + 1)(0)
    val ps = words.foldLeft(initialPs)((accPs, word) => {
      val pi = prefixFunction(word + "#" + target)
      (1 to targetLen).foldLeft(accPs)((updatedPs, i) => updatedPs.updated(i, updatedPs(i).max(pi(word.length + i))))
    })

    @scala.annotation.tailrec
    def countValidStrings(len: Int, res: Int): Int =
      if (len == 0) res
      else if (ps(len) == 0) -1
      else countValidStrings(len - ps(len), res + 1)

    countValidStrings(targetLen, 0)
  }
}
