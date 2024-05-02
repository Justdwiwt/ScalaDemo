package leetCode._1100

import scala.collection.mutable.ListBuffer

object Solution_1087 {
  def expand(S: String): Array[String] =
    if (!S.contains("{")) Array(S)
    else {
      val res = ListBuffer.empty[String]
      backTrace(S, new StringBuilder(), 0, res)
      res.sorted.toArray
    }

  private def backTrace(s: String, sb: StringBuilder, index: Int, res: ListBuffer[String]): Unit =
    if (index == s.length) res += sb.toString()
    else {
      if (s.charAt(index) == '{') {
        var count = 0
        var j = index + 1
        while (s.charAt(j) != '}') {
          count += 1
          j += 1
        }
        (index + 1 until index + count + 1).foreach(j => {
          val ch = s.charAt(j)
          if (ch != ',') {
            val updatedSb = sb.append(ch)
            backTrace(s, updatedSb, index + count + 2, res)
            updatedSb.deleteCharAt(updatedSb.length - 1)
          }
        })
      } else {
        val updatedSb = sb.append(s.charAt(index))
        backTrace(s, updatedSb, index + 1, res)
        updatedSb.deleteCharAt(updatedSb.length - 1)
      }
    }
}
