package leetCode._2100

object Solution_2030 {
  def smallestSubsequence(s: String, k: Int, letter: Char, repetition: Int): String = {
    var cnt = s.count(_ == letter)
    val sb = new StringBuilder

    var idx = 0
    var remainingRepetitions = repetition
    while (idx < s.length) {
      cnt -= (if (s.charAt(idx) == letter) 1 else 0)
      while (
        sb.length + s.length > idx + k &&
          sb.nonEmpty &&
          s.charAt(idx) < sb.last &&
          (sb.last != letter || cnt != remainingRepetitions)
      ) {
        remainingRepetitions += (if (sb.last == letter) 1 else 0)
        sb.deleteCharAt(sb.length - 1)
      }
      if (k - sb.length > Math.max(0, if (s.charAt(idx) == letter) 0 else remainingRepetitions)) {
        sb.append(s.charAt(idx))
        remainingRepetitions -= (if (s.charAt(idx) == letter) 1 else 0)
      }
      idx += 1
    }

    sb.mkString
  }
}
