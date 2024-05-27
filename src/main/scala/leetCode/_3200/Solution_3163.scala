package leetCode._3200

object Solution_3163 {
  def compressedString(word: String): String = {
    @scala.annotation.tailrec
    def f(i: Int, count: Int, cur: Char, acc: StringBuilder): String =
      if (i >= word.length) {
        if (count > 0) acc.append(count).append(cur)
        acc.toString()
      } else {
        val char = word.charAt(i)
        if (char == cur && count < 9) f(i + 1, count + 1, cur, acc)
        else {
          acc.append(count).append(cur)
          f(i + 1, 1, char, acc)
        }
      }

    if (word.isEmpty) ""
    else f(1, 1, word.head, new StringBuilder)
  }
}
