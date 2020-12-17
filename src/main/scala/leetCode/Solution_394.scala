package leetCode

object Solution_394 {
  def decodeString(s: String): String = {
    @scala.annotation.tailrec
    def findEncodedEndIdx(idx: Int, str: String, pars: Int = -1): Int =
      if (pars == 0) idx
      else str(idx) match {
        case '[' if pars == -1 => findEncodedEndIdx(idx + 1, str, 1)
        case '[' => findEncodedEndIdx(idx + 1, str, pars + 1)
        case ']' => findEncodedEndIdx(idx + 1, str, pars - 1)
        case _ => findEncodedEndIdx(idx + 1, str, pars)
      }

    def decode(str: String, res: String): String =
      if (str.isEmpty) res
      else if (str.head.isDigit) {
        val cnt = str.takeWhile(_.isDigit).toInt
        val begin = str.indexOf('[')
        val end = findEncodedEndIdx(begin, str)
        val decoded = decode(str.substring(begin + 1, end - 1), "") * cnt
        decode(str.substring(end), res + decoded)
      } else decode(str.tail, res + str.head)

    decode(s, "")
  }
}
