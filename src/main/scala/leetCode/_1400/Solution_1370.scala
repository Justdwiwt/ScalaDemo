package leetCode._1400

object Solution_1370 {
  def sortString(s: String): String = {
    @scala.annotation.tailrec
    def f(str: String, res: String, isReversed: Boolean): String =
      if (str.isEmpty) res
      else if (isReversed) {
        val sortedStr = str.distinct.sorted
        f(sortedStr.foldLeft(str)((acc, i) => acc.replaceFirst(i.toString, "")), res + sortedStr, isReversed = false)
      } else {
        val sortedStr = str.distinct.sorted.reverse
        f(sortedStr.foldLeft(str)((acc, i) => acc.replaceFirst(i.toString, "")), res + sortedStr, isReversed = true)
      }

    f(s, "", isReversed = true)
  }
}
