package leetCode._500

object Solution_411 {
  private var Min: Int = Int.MaxValue
  private var best: Int = 0

  private def abbrLen(fix: Int, length: Int): Int = {
    val res = (0 until length).foldLeft((0, 0))((acc, i) => {
      val (ans, cnt) = acc
      if ((fix & (1 << i)) != 0) {
        val newCnt = if (cnt != 0) (if (cnt > 9) 2 else 1) - cnt else 0
        (ans + 1 + newCnt, 0)
      } else (ans, cnt + 1)
    })
    res._1 + (if (res._2 != 0) (if (res._2 > 9) 2 else 1) - res._2 else 0)
  }

  private def canFix(words: Array[Int], fix: Int): Boolean =
    words.forall(word => (fix & word) != 0)

  private def dfs(words: Array[Int], length: Int, fix: Int, index: Int): Unit = {
    def f(fix: Int, index: Int): Unit =
      if (!canFix(words, fix)) {
        if (index < length) {
          f(fix, index + 1)
          f(fix | (1 << index), index + 1)
        }
      } else {
        val ans = abbrLen(fix, length)
        if (ans < Min) {
          Min = ans
          best = fix
        }
      }

    f(fix, index)
  }

  def minAbbreviation(target: String, dictionary: Array[String]): String = {
    Min = Int.MaxValue
    best = 0
    val ch = target.toCharArray
    val n = ch.length
    val words = dictionary
      .filter(_.length == n)
      .map(word => {
        val status = word
          .toCharArray
          .zipWithIndex
          .foldLeft(0) { case (acc, (char, j)) => if (ch(j) != char) acc | (1 << j) else acc }
        status
      })

    dfs(words, n, 0, 0)

    (0 until n).foldLeft((new StringBuilder, 0)) { case ((acc, count), i) =>
      if ((best & (1 << i)) != 0) {
        val newAcc = if (count != 0) acc.append(count) else acc
        (newAcc.append(ch(i)), 0)
      } else (acc, count + 1)
    } match {
      case (acc, count) =>
        val finalAcc = if (count > 0) acc.append(count) else acc
        finalAcc.toString
    }
  }
}
