package leetCode._3500

object Solution_3406 {
  def answerString(word: String, numFriends: Int): String = {
    if (numFriends == 1) return word
    val n = word.length

    def findBestSplit(i: Int, j: Int): (Int, Int) = {
      var k = 0
      while (j + k < n && word(i + k) == word(j + k))
        k += 1
      if (j + k < n && word(i + k) < word(j + k)) (j, (j + 1).max(i + k + 1))
      else (i, j + k + 1)
    }

    @scala.annotation.tailrec
    def findLargestSubstring(i: Int, j: Int): Int =
      if (j >= n) i
      else {
        val (newI, newJ) = findBestSplit(i, j)
        findLargestSubstring(newI, newJ)
      }

    val i = findLargestSubstring(0, 1)
    word.substring(i, n.min(i + n - numFriends + 1))
  }
}
