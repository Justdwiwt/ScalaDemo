package leetCode._100

object Solution_14 {
  def longestCommonPrefix(strs: Array[String]): String =
    if (strs.isEmpty) ""
    else strs.reduce((a, b) => a.zip(b).takeWhile(c => c._1 == c._2)./:("")(_ + _._1))
}
