package leetCode._600

object Solution_555 {
  def splitLoopedString(strs: Array[String]): String = {
    val enhancedStrs = strs.map(str => {
      val rev = str.reverse
      if (rev > str) rev else str
    })

    val res = enhancedStrs.indices.flatMap(i => {
      val str = enhancedStrs(i)
      val rev = str.reverse
      val other = (enhancedStrs.drop(i + 1) ++ enhancedStrs.take(i)).mkString

      str.indices.flatMap(j => {
        val cur = str.substring(j) + other + str.substring(0, j)
        val curRev = rev.substring(j) + other + rev.substring(0, j)
        Seq(cur, curRev)
      })
    }).max

    res
  }
}
