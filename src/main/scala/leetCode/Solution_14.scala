package leetCode

object Solution_14 {
  def longestCommonPrefix(strs: Array[String]): String = {
    if (strs.length == 0) return ""
    if (strs.length == 1) strs(0)
    (0 until strs(0).length).foreach(i =>
      (1 until strs.length).foreach(j =>
        if ((i >= strs(j).length) || strs(j)(i) != strs(0)(i))
          return strs(0).substring(0, i)))
    strs(0)
  }
}
