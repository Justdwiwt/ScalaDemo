package leetCode._1100

object Solution_1092 {
  def shortestCommonSupersequence(str1: String, str2: String): String = {
    val dp = Array.fill(str1.length + 1, str2.length + 1)(0)
    val path = Array.fill(str1.length + 1, str2.length + 1)(0)
    (1 to str1.length).foreach(i => path(i)(0) = 1)
    (1 to str2.length).foreach(i => path(0)(i) = 2)
    (1 to str1.length).foreach(i => (1 to str2.length).foreach(j => {
      dp(i)(j) = dp(i - 1)(j)
      path(i)(j) = 1
      if (dp(i)(j - 1) > dp(i)(j)) {
        dp(i)(j) = dp(i)(j - 1)
        path(i)(j) = 2
      }
      if (str1(i - 1) == str2(j - 1) && (dp(i - 1)(j - 1) + 1 > dp(i)(j))) {
        dp(i)(j) = dp(i - 1)(j - 1) + 1
        path(i)(j) = 3
      }
    }))
    var res = ""
    var i = str1.length
    var j = str2.length
    while (path(i)(j) != 0) path(i)(j) match {
      case 1 =>
        i -= 1
        res += str1(i)
      case 2 =>
        j -= 1
        res += str2(j)
      case _ =>
        i -= 1
        res += str1(i)
        j -= 1
    }
    res.reverse
  }
}
