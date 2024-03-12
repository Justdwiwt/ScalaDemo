package leetCode._1700

object Solution_1668 {
  def maxRepeating(sequence: String, word: String): Int = {
    if (!sequence.contains(word)) 0
    else {
      var cnt = 1
      var t = word
      while (sequence.contains(t)) {
        cnt += 1
        t = word * cnt
      }
      cnt - 1
    }
  }
}
