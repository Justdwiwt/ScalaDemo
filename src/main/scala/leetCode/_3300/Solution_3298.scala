package leetCode._3300

object Solution_3298 {
  def validSubstringCount(S: String, T: String): Long = {
    if (S.length < T.length) return 0

    val s = S.toCharArray
    val t = T.toCharArray
    val cnt = Array.fill(26)(0)
    t.foreach(b => cnt(b - 'a') += 1)

    var less = cnt.count(_ > 0)

    var res = 0L
    var left = 0

    s.foreach(b => {
      cnt(b - 'a') -= 1
      if (cnt(b - 'a') == 0) less -= 1

      while (less == 0) {
        val outChar = s(left)
        left += 1
        if (cnt(outChar - 'a') == 0) less += 1
        cnt(outChar - 'a') += 1
      }

      res += left
    })

    res
  }
}
