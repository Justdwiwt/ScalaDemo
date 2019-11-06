package leetCode

object Solution_474 {
  def findMaxForm(strs: Array[String], m: Int, n: Int): Int = {
    val items = strs map countStr
    val dp = Array.fill(items.length + 1, m + 1, n + 1)(0)
    (1 to items.length).foreach(i => (0 to m).foreach(j => (0 to n).foreach(k =>
      if (items(i - 1)._1 > j || items(i - 1)._2 > k) dp(i)(j)(k) = dp(i - 1)(j)(k)
      else dp(i)(j)(k) = dp(i - 1)(j)(k) max (dp(i - 1)(j - items(i - 1)._1)(k - items(i - 1)._2) + 1))
    ))
    dp(items.length)(m)(n)
  }

  def countStr(s: String): (Int, Int) = countStr(s.toList, (0, 0))

  @scala.annotation.tailrec
  def countStr(s: List[Char], acc: (Int, Int)): (Int, Int) = s match {
    case Nil => acc
    case '0' :: t => countStr(t, (acc._1 + 1, acc._2))
    case '1' :: t => countStr(t, (acc._1, acc._2 + 1))
  }
}
