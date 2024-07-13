package leetCode.crackingCodeInterview

object Code_17_17 {
  private var res: Array[Array[Int]] = _
  private var globalBig: String = _

  def multiSearch(big: String, smalls: Array[String]): Array[Array[Int]] = {
    globalBig = big
    res = smalls.indices.map(i => f(smalls(i))).toArray
    res
  }

  private def f(str: String): Array[Int] =
    if (str.isEmpty) Array.empty[Int]
    else Stream
      .iterate(globalBig.indexOf(str))(idx => globalBig.indexOf(str, idx + 1))
      .takeWhile(_ >= 0)
      .toArray
}
