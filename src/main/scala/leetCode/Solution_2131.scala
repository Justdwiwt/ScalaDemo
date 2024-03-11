package leetCode

object Solution_2131 {
  def longestPalindrome(words: Array[String]): Int = {
    val t = words.filter(_.distinct.length == 1).groupBy(identity).mapValues(_.length)
    val t1 = scala.util.Try(t.values.filter(_ == 1).max).getOrElse(0) * 2 +
      t.values.filter(_ % 2 == 0).sum * 2 +
      t.values.filter(_ % 2 == 1).filter(_ != 1).map(_ - 1).sum * 2 +
      (if (t.values.filter(_ % 2 == 1).exists(_ != 1) && !t.values.exists(_ == 1)) 2 else 0)
    val maps = words.filter(_.distinct.length == 2).groupBy(identity).mapValues(_.length)
    val maps2 = maps.filter(n => maps.contains(n._1.reverse))
    maps2.map(n => maps2.getOrElse(n._1.reverse, 0).min(n._2)).sum * 2 + t1
  }
}
