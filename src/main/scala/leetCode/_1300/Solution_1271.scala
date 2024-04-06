package leetCode._1300

object Solution_1271 {
  def toHexspeak(num: String): String = {
    val hexString = num
      .toLong
      .toHexString
      .toUpperCase
      .replace('1', 'I')
      .replace('0', 'O')

    val dir = Set('A', 'B', 'C', 'D', 'E', 'F', 'I', 'O')

    @scala.annotation.tailrec
    def f(s: String, idx: Int): String =
      if (idx < s.length)
        if (!dir.contains(s.charAt(idx))) "ERROR"
        else f(s, idx + 1)
      else s

    f(hexString, 0)
  }
}
