package leetCode._3500

object Solution_3403 {
  def answerString(word: String, numFriends: Int): String =
    if (numFriends == 1) word
    else {
      val n = word.length
      word.indices.map(i => word.substring(i, (i + n - numFriends + 1).min(n))).max
    }
}
